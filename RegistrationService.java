package com.xworkz.vaccine.service;

import com.xworkz.vaccine.dto.RegistrationDTO;

public interface RegistrationService {
	
	public boolean validateRegistrationDTO(String name,String gender,String password,String mobile);
	
	
	public boolean sendPasswordToEmail(String email,String password);

	public boolean saveRegistrationDTO(String name,String gender,String password,String mobile);
	
	
}
