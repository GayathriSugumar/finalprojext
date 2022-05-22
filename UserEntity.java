package com.xworkz.vaccine.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.Data;

@Data
@Table(name="vaccine")
@Entity
@NamedQueries({
@NamedQuery(name="getEmailFromTable",query="Select vaccine.email from UserEntity as vaccine where email=:EMAIL"),
@NamedQuery(name="getOTPFromTable",query="Select otp.OTP from UserEntity as otp where OTP=:OTP"),
@NamedQuery(name = "getMemberCount", query = "select value.memberCount from UserEntity as value  WHERE email=:Email"),
@NamedQuery(name = "updateMemberCount", query = "update UserEntity SET memberCount=:Count  WHERE email=:Email"),

})
public class UserEntity {
	@Column(name="userId")
	@Id
	@GenericGenerator(name="abc", strategy="increment")
	@GeneratedValue(generator="abc")
	private int UserId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="OTP")
	private int OTP;

	@Column(name="MEMBERCOUNT")
	private int memberCount;

	

}
