package com.xworkz.vaccine.service;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.dao.WellcomeDAO;
import com.xworkz.vaccine.dto.WellcomeDTO;
import com.xworkz.vaccine.entity.UserEntity;
import com.xworkz.vaccine.exception.DuplicateEmailException;
import com.xworkz.vaccine.exception.InvalidEMailException;
@Component
public class WellcomeServiceImpl implements WellcomeService{
    @Autowired
	private WellcomeDAO wellcome;
    
    @Autowired
    private MailSender mailSender;
    
	public WellcomeServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
		System.out.println("Invoked WellcomeServiceImpl ");
	}

	public boolean validateEmail(String email)throws InvalidEMailException  {
		System.out.println("Invoked validate Email");
		boolean valid = false;
		try {
			if (email != null && !email.isEmpty() && email.length() >= 8 && email.contains("@")
					&& (email.endsWith(".com") || email.endsWith(".in") || email.endsWith(".org")
							|| email.endsWith(".gov"))) {
				System.out.println("Entered Email is valid");
				return true;
			}
		} catch (InvalidEMailException e) {
			InvalidEMailException invalidEmail = new InvalidEMailException();
			throw invalidEmail;
		}
		return valid;
	}

	@SuppressWarnings("unused")
	@Override
	public int getFourDigitOTP() {
		System.out.println("Invoked getFourDigitOTP() ");
		Random random=new Random();
		int otp = (int) (Math.random() * 9000) + 1000;
		if(otp!=0 && otp>=4) {
		System.out.println("OTP :" +otp);
		}else {
			System.out.println("OTP is Invalid");
		}
		return otp;
		
	}

	@Override
	public boolean saveOTPToDB(String email,int otp) {
		System.out.println("Invoked saveOTPToDB()");
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail(email);	
		userEntity.setOTP(otp);
		boolean isOTPSaved=wellcome.saveUserEntity(userEntity);
		return isOTPSaved;
	}

	@Override
	public boolean sendOTPToUserEmail(String email,int otp) {
		System.out.println("Invoked sendOTPToUserEmail()");
		SimpleMailMessage message=new SimpleMailMessage();
		try {
		message.setTo(email);
		message.setSubject("Verification OTP Generated");
		message.setText(email+otp);
		mailSender.send(message);
		System.out.println("OTP sent successfully");
		return true;
		}catch(Exception exception ) {
			System.out.println("OTP is  not sent ");
			exception.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean checkIsExistingEmail(String email) {
	System.out.println("Invoked checkIsExistingEmail");
	boolean flag=false;
	try {
		String EmailFromDB=wellcome.getEmailFromTable(email);
		if (!email.equals(EmailFromDB)) {
			System.out.println("Email is verified !...");
			flag=true;
			return flag;
		} else {
			throw new DuplicateEmailException("Duplicate of Email Id/Email Id is already exist,Duplicate  Email");
		}
		
	} catch (DuplicateEmailException exception) {
		System.out.println("It is Invalid Email!... Already Exists!..");
	}
	return flag;
	
		
	}


			

}
