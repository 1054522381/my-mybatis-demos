package cn.com.fubon.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import cn.com.fubon.mybatis.domain.Group;
import cn.com.fubon.mybatis.domain.House;
import cn.com.fubon.mybatis.domain.Person;
import cn.com.fubon.mybatis.mapper.PersonMapper;

public class SimpleTest {
	private static SqlSessionFactory sqlSessionFactory ;
	
	@BeforeClass
	public static void beforeClass() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		inputStream.close();
	}
	
	@Test
	public void testSelectOnePerson(){
		SqlSession session = sqlSessionFactory.openSession();
		Person person = session.selectOne("SelectOnePerson",1);
		System.out.println(person);
	}

	@Test
	public void testSelectAllPerson(){
		SqlSession session = sqlSessionFactory.openSession();
		List<Person> persons = session.selectList("SelectAllPerson");
		System.out.println(persons);
	}
	
	@Test
	public void testSave(){
		SqlSession session = sqlSessionFactory.openSession();
		Person person = new Person("amy",5);
		int affectedRows = session.insert("Save", person);
		session.commit();
		System.out.println("affectedRows=" + affectedRows); 
	}
	
	@Test
	public void testUpdate(){
		SqlSession session = sqlSessionFactory.openSession();
		Person person = session.selectOne("SelectOnePerson",1);
		System.out.println("旧age=" + person.getAge());
		person.setAge(person.getAge()!=null ? person.getAge()+1 : 1);
		session.update("Update", person);
		session.commit();
		System.out.println("新age=" + person.getAge());
	}
	
	@Test
	public void testDelete(){
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("Delete", 6);
		session.commit();
	}
	
	/**
	 * 测试一对多
	 */
	@Test
	public void testOneToMany(){
		SqlSession session = sqlSessionFactory.openSession();
		List<Person> persons = session.selectList("getPerson", 2);
		System.out.println(persons);
	}

	/**
	 * 测试多对一
	 */
	@Test
	public void testManyToOne(){
		SqlSession session = sqlSessionFactory.openSession();
		Person person = session.selectOne("getHouse", 1);
		System.out.println(person);
	}
	
	/**
	 * 测试多对多,根据一个组id,查看这个组下的所有用户
	 */
	@Test
	public void testManyToMany(){
		SqlSession session = sqlSessionFactory.openSession();
		List<Person> persons = session.selectList("getPersonsByGroupId", 1);
		System.out.println(persons);
	}
	
	/**
	 * 测试多对多,根据一个person_id,查看这个person归属的所有组
	 */
	@Test
	public void testManyToMany2(){
		SqlSession session = sqlSessionFactory.openSession();
		List<Group> groups = session.selectList("getGroupsByPersonId", 1);
		System.out.println(groups);
	}
	
	/**
	 * 测试多对多，根据id获取group
	 */
	@Test
	@Ignore
	public void testGetGroup(){
		SqlSession session = sqlSessionFactory.openSession();
		Group group = session.selectOne("getGroup", 1);
		System.out.println(group);
	}
	
	/**
	 * 往下的测试是Mapper的接口
	 */
	@Test
	public void testMapperGetPersonById(){
		SqlSession session = sqlSessionFactory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = mapper.getPersonById(1);
		System.out.println(person);
	}
	
	@Test
	public void testMapperGetAllPerson(){
		SqlSession session = sqlSessionFactory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		List<Person> persons = mapper.getAllPerson();
		System.out.println(persons);
	}

	@Test
	public void testMapperSave(){
		SqlSession session = sqlSessionFactory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = new Person("wangwu",3);
		mapper.save(person);
		session.commit();
		System.out.println("id=" + person.getId()); //id读不到
	}

	@Test
	public void testMapperUpdate(){
		SqlSession session = sqlSessionFactory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = session.selectOne("SelectOnePerson",1);
		System.out.println("旧age=" + person.getAge());
		person.setAge(person.getAge()!=null ? person.getAge()+1 : 1);
		mapper.update(person);
		session.commit();
		System.out.println("新age=" + person.getAge());
	}
	

	@Test
	public void testMapperDelete(){
		SqlSession session = sqlSessionFactory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		mapper.delete(5);
		session.commit();
	}
}
