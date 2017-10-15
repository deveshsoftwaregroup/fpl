package com.sportmgmt.model.manager;


import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sportmgmt.utility.common.PropertyFileUtility;

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
				ResourceBundle resouceBundle= PropertyFileUtility.getEnvProperty();
				
				configuration = new Configuration().configure();
				Properties properties = configuration.getProperties();
				
				properties.setProperty("hibernate.connection.url", resouceBundle.getString("connection.url"));
				properties.setProperty("hibernate.connection.username", resouceBundle.getString("connection.username"));
				properties.setProperty("hibernate.connection.password", resouceBundle.getString("connection.password"));
				
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
