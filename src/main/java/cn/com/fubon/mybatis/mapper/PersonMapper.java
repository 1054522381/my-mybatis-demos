package cn.com.fubon.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.com.fubon.mybatis.domain.Person;

/**
 * 全类名要和PersonMapper.xml中定义的namespace一致
 * @author guo
 *
 */
public interface PersonMapper {
	/* 查询列表中没有列的字段会是null */
	@Select("select id,name from person where id= #{id}")
	public Person getPersonById(Integer id);
	
	@Select("select * from person")
	public List<Person> getAllPerson();
	
	@Insert("insert into person(name,age) values(#{name},#{age})")
	public void save(Person person);
	
	@Update("update person set name=#{name} ,age=#{age} where id=#{id}")
	public void update(Person person);
	
	@Delete("delete from person where id=#{id}")
	public void delete(Integer id);
}
