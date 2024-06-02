package com.test;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtils3 {
	private static SessionFactory sessionFactory;

	private HibernateUtils3() {
		// prevent instantiation from out side class
	}

	// Method to return the sessionFactory Object
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = createSessionFactory();
		}
		return sessionFactory;
	}

	private static SessionFactory createSessionFactory() {
		StandardServiceRegistry serviceRegistry = null;
		try {
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

			// Define configuration properties
			Map<String, String> settings = new HashMap<String, String>();
			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

			registryBuilder.applySettings(settings);

			serviceRegistry = registryBuilder.build();
			MetadataSources sources = new MetadataSources(serviceRegistry).addAnnotatedClass(Student.class);
			Metadata metadata = sources.getMetadataBuilder().build();

			return metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			e.printStackTrace();
			if (serviceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
			}
			throw new RuntimeException("There was an error building the sessionFactory", e);
		}
	}
}
