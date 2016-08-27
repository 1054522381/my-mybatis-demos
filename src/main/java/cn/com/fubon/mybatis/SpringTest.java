package cn.com.fubon.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.fubon.mybatis.domain.Person;

public class SpringTest {
    private static SqlSessionFactory factory;
    
    @BeforeClass
    public static void beforeClass() throws Exception{
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	SqlSessionFactoryBean bean = ctx.getBean(SqlSessionFactoryBean.class);
    	factory = bean.getObject();
    }
    
    @Test
    public void test1(){
    	SqlSession session = factory.openSession();
    	List<Person> persons = session.selectList("SelectAllPerson");
		System.out.println(persons);
    }
}
