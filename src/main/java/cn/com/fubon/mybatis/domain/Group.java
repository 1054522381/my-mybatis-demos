package cn.com.fubon.mybatis.domain;

import java.util.List;

/*
 * 
CREATE TABLE `group` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT '0' COLLATE 'gbk_chinese_ci',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3
;

CREATE TABLE `person_group` (
	`person_id` INT(10) NULL DEFAULT '0',
	`group_id` INT(10) NULL DEFAULT NULL,
	INDEX `FK_person_group_person` (`person_id`),
	INDEX `FK_person_group_group` (`group_id`),
	CONSTRAINT `FK_person_group_group` FOREIGN KEY (`group_id`) REFERENCES `group` (`id`),
	CONSTRAINT `FK_person_group_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
)

 */
public class Group {
	private Integer id;
	private String name;
	private List<Person> persons;
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
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return " id=" + id + ",name=" + name + ",persons=" + persons + ";";
	}
}
