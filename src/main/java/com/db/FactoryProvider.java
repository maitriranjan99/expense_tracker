package com.db;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryProvider {
	public static EntityManagerFactory factory;
	public static EntityManagerFactory getFactory()
	{
		if(factory == null)
		{
			factory = Persistence.createEntityManagerFactory("dev");
		}
		return factory;
	}

}
