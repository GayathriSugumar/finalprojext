package com.xworkz.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class RegistrationDAOImpl implements RegistrationDAO{
	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean saveRegistration(Object registerEntity) {
		System.out.println("Invoked saveRegistration ");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(registerEntity);
			session.getTransaction().commit();
			System.out.println("registerEntity is saved");
			System.out.println(registerEntity);
			return true;
		} catch (Exception exception) {
			System.out.println("registerEntity is not saved");
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}

}
