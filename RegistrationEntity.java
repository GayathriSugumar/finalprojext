package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;
import lombok.Data;

@Data
@Table(name="Registration")
@Entity
//@NamedQuery(name="",query="")
public class RegistrationEntity {

	@Column(name="ID")
	@Id
	@GenericGenerator(name="abc",strategy="increment")
	@GeneratedValue(generator="abc")
	private int id;
	
	@Column(name="NAME")
	private String name;

	@Column(name="GENDER")
	private String gender;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@Column(name="PASSWORD")
	private String password;
}
