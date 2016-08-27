package cn.com.fubon.mybatis.domain;

import java.util.Date;

/*
CREATE TABLE `house` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'gbk_chinese_ci',
	`person_id` INT(11) NOT NULL,
	`startdate` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_house_person` (`person_id`),
	CONSTRAINT `FK_house_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
)
COLLATE='gbk_chinese_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;

 */
public class House {
	private Integer id;
	private String name;
	private Date startDate;
	private Person person;
	
	public House(){
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return " id=" + id + ",name=" + name + ",startDate=" + startDate + ";";
	}
}
