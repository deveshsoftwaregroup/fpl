package com.sportmgmt.model.manager;


import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.sportmgmt.utility.constrant.SportConstrant;

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
				//ResourceBundle resourceBundleCommon = ResourceBundle.getBundle(SportConstrant.ENV_FILE_NAME_COMMON);
				ResourceBundle resourceBundle = PropertyFileUtility.getEnvProperty();
				
				configuration = new Configuration().configure();
				Properties properties = configuration.getProperties();

				properties.setProperty(SportConstrant.HIBERNATE_CONNECTION_URL, resourceBundle.getString("connection.url"));
				properties.setProperty(SportConstrant.HIBERNATE_CONNECTION_USERNAME, resourceBundle.getString("connection.username"));
				properties.setProperty(SportConstrant.HIBERNATE_CONNECTION_PASSWORD, resourceBundle.getString("connection.password"));
				
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
