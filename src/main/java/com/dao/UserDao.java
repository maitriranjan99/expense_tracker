package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.db.FactoryProvider;
import com.entity.User;

public class UserDao {
	private EntityTransaction transaction = null;
	private EntityManager manager = null;
	
	public boolean saveUser(User u)
	{
		boolean f = false;
		try {
			manager = FactoryProvider.getFactory().createEntityManager();
			transaction = manager.getTransaction();
			
			manager.persist(u);
			transaction.begin();
			transaction.commit();
			f= true;
			
		} catch (Exception e) {
			if(transaction != null)
			{
				f = false;
				e.printStackTrace();
			}
		}
		return f;
	}
	public User login(String email, String password)
	{
		User u = null;
		manager = FactoryProvider.getFactory().createEntityManager();
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		u =(User)q.getSingleResult();
		
		return u;
	}

}
