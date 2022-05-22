package com.xworkz.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.service.RegistrationService;

@Component
@RequestMapping("/")
public class RegistrationController {
	public static String email;
	
	@Autowired
	private RegistrationService register;
	
	public RegistrationController() {
		System.out.println(this.getClass().getSimpleName() + "Bean is created");
	}
	
	@RequestMapping("/Registration.data")
	public String onClickRegistration(@RequestParam String name,@RequestParam String gender,@RequestParam String password,@RequestParam String mobile,@RequestParam String email,Model model) {
		System.out.println("*****************************");
		System.out.println("Invoked onClickRegistration");
		WellcomeController.email=email;
		boolean isValidate=register.validateRegistrationDTO(name, gender, password, mobile);
		System.out.println("All fields are validated");
		if (isValidate) {
			boolean isMailSent=register.sendPasswordToEmail(email, password);
		if (isMailSent) {
			model.addAttribute("message", "Password send to user email");
			System.out.println("Password send to user email successfully");
			
			boolean isDataSaved=register.saveRegistrationDTO(name, gender, password, mobile);
			if (isDataSaved) {
				model.addAttribute("message", "Data Saved Successfully");
				System.out.println("Data is saved into database");
				return "/WEB-INF/VaccineHomePage.jsp";
			} else {
				model.addAttribute("message", "Data is not Saved Successfully");
				System.out.println("Data is not saved into database");
			}
		} else {
			model.addAttribute("message", "password is not sent to email");
			System.out.println("Password is not send to user email!.....");
		}
		} else {
			System.out.println("Fields are Invalid!...Try Again");
		}
		return "/WellcomePage.jsp";
		
	}
	
}
