package com.xworkz.vaccine.dao;

import java.util.Random;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xworkz.vaccine.entity.UserEntity;

@Component
public class WellcomeDAOImpl implements WellcomeDAO {

	@Autowired
	private SessionFactory factory;
	
	public WellcomeDAOImpl() {
		System.out.println(this.getClass().getSimpleName()+"Bean Created");
	}


	@Override
	public boolean saveUserEntity(Object userEntity) {
		System.out.println("Invoked saveUserEntity() ");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(userEntity);
			session.getTransaction().commit();
			System.out.println("Entity is saved");
			System.out.println(userEntity);
			return true;
		} catch (Exception exception) {
			System.out.println("Entity is not saved");
			session.getTransaction().rollback();
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return false;
	}


	@Override
	public String getEmailFromTable(String email) {
		System.out.println("Invoked getEmailFromTable");
		Session session = null;
		String Email =null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("getEmailFromTable");
			query.setParameter("EMAIL",email);
			Email= (String) query.getSingleResult();
			System.out.println("Email From DB : " + email);
//			return email;
		} catch (Exception emailException) {
			session.getTransaction().rollback();
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return email;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public int getMemberCountByEmail(String email) {
		System.out.println("Invoked getMemberCountByEmail");
		Session session = null;
		int memberCount=0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("getMemberCount");
			query.setParameter("Email",email);
			memberCount = (int) query.getSingleResult();
			System.out.println("Membercount is : " + memberCount);
			return memberCount;
		} catch (Exception emailException) {
			session.getTransaction().rollback();
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return memberCount;
	}


	@SuppressWarnings({ "null", "rawtypes" })
	@Override
	public int updateMemberCount(String email, int count) {
		System.out.println("Invoked updateMemberCount");
		Session session = null;
		Transaction transaction = null;
		int update=0;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("updateMemberCount");
			query.setParameter("Email",email);
			query.setParameter("Count", count);
			update = query.executeUpdate();
			transaction.commit();
			return update;
		} catch (Exception exception) {
			session.getTransaction().rollback();
			System.out.println("Count not incremented!...");
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return update;
	}

}
