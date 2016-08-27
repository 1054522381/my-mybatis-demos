package cn.com.fubon.mybatis.domain;

import java.util.List;

/*
CREATE TABLE `person` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT '0' COLLATE 'gbk_chinese_ci',
	`age` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=11
;

 */
public class Person {

	private Integer id;
	private String name;
	private Integer age;
	private List<House> houses;
	private List<Group> groups;
	
	public Person(){
	}
	
	public Person(String name,Integer age){
		this.name = name;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "id=" + id + ",name=" + name + ",age=" + age 
				+ ",houses[" + houses 
				+ "],groups[" + groups
				+ "];";
	}
	
}
