package com.sportmgmt.model.manager;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static Configuration configuration = null;
	private static StandardServiceRegistryBuilder builder = null;
	private static SessionFactory factory = null;
	private static Logger logger = Logger.getLogger(HibernateSessionFactory.class);
	public static SessionFactory getSessionFacotry()
	{
		if(factory == null)
		{
			try
			{
				configuration = new Configuration().configure();
				builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				factory = configuration.buildSessionFactory(builder.build());
			}
			catch(Exception ex)
			{
				System.out.println("Exception occures to get Session Factory: "+ex);
				logger.error("Error to create Session Factory: "+ex.getMessage());
				ex.printStackTrace();
				return null;
			}
		}
		return factory;
	}
}
