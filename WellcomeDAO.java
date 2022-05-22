package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.UserEntity;

public interface WellcomeDAO {
	
	public boolean saveUserEntity(Object userEntity);
	
	public String getEmailFromTable(String email);
	
	public int getMemberCountByEmail(String email);
	
	public int updateMemberCount(String email,int count);

}
