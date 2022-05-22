package com.xworkz.vaccine.service;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.vaccine.controller.WellcomeController;
import com.xworkz.vaccine.dao.RegistrationDAO;
import com.xworkz.vaccine.dto.RegistrationDTO;
import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.entity.RegistrationEntity;
import com.xworkz.vaccine.exception.InvalidGenderException;
import com.xworkz.vaccine.exception.InvalidMobileException;
import com.xworkz.vaccine.exception.InvalidNameException;
import com.xworkz.vaccine.exception.InvalidPasswordException;

@Component
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDAO registerDao;
	
	@Autowired
	private MailSender mailSender;

	public RegistrationServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
		System.out.println("Invoked RegistrationServiceImpl ");
	}

	@Override
	public boolean validateRegistrationDTO(String name,String gender,String password,String mobile) {
		System.out.println("Invoked validateAddMemberDTO");
		boolean temp=false;
		if(name !=null && !name.isEmpty() && name.length()>=2){
			System.out.println("Register name is valid");
			temp=true;
		}else {
			InvalidNameException invalidNameException = new InvalidNameException();
			throw invalidNameException;
		}
		if (gender !=null && !gender.isEmpty()) {
			System.out.println("Gender is valid");
			temp=true;
		} else {
			InvalidGenderException invalidGenderException = new InvalidGenderException();
			throw invalidGenderException;
		}
		if (password != null && !password.isEmpty() && password.length() > 3 && password.length() < 20
				&& (password.contains("*") || password.contains("@") || password.contains("&")
						|| password.contains("%") || password.contains("!") || password.contains("_")
						|| password.contains("$"))) {
			System.out.println("Password is Valid ");
			temp=true;
		} else {
			InvalidPasswordException invalidPasswordException = new InvalidPasswordException();
			throw invalidPasswordException;
		}
		if (!mobile.isEmpty() && mobile.length()>=10) {
			System.out.println("Mobile number is valid");
			temp=true;
		} else {
			InvalidMobileException invalidMobileException = new InvalidMobileException();
			throw invalidMobileException;
		}
		return temp;
	}
	
	
	@Override
	public boolean sendPasswordToEmail(String email, String password) {
		System.out.println("Invoked sendPasswordToEmail!...");
		WellcomeController.email=email;
		SimpleMailMessage message=new SimpleMailMessage();
		try {
		message.setTo(email);
		message.setSubject("Your Password is :");
		message.setText(email+password);
		mailSender.send(message);
		System.out.println("Password sent to email successfully");
		return true;
		}catch(Exception exception ) {
			System.out.println("Password is not sent to email ");
			exception.printStackTrace();
		}
		return false;
	}



	@Override
	public boolean saveRegistrationDTO(String name,String gender,String password,String mobile) {
		System.out.println("Invoked saveRegistrationDTO");
		boolean isEntitySaved=false;
		RegistrationEntity registrationEntity = new RegistrationEntity();
			try {
				registrationEntity.setName(name);
			    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt()); 
				registrationEntity.setPassword(hashedPassword);
				registrationEntity.setGender(gender);
				registrationEntity.setMobile(mobile);
			} catch (Exception e) {
				System.out.println("Registration entity is not valid");
			}
		return isEntitySaved;
}

	
	
}
