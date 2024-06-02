package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils2 {
	private static SessionFactory sessionFactory;

	private HibernateUtils2() {
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
			// Create StandardServiceRegistry
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistry = serviceRegistryBuilder.configure().build();

			// Create MetadataSource
			MetadataSources metadataSources = new MetadataSources(serviceRegistry);
			//metadataSources.addAnnotatedClass(Student.class);

			// Create Metadata
			Metadata metaData = metadataSources.getMetadataBuilder().build();

			// Create SessionFactory
			return metaData.getSessionFactoryBuilder().build();

		} catch (Exception e) {
			e.printStackTrace();
			if (serviceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(serviceRegistry);
			}
			throw new RuntimeException("There was an error building the sessionFactory", e);
		}
	}
}
