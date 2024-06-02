package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		Session session = HibernateUtils2.getSessionFactory().openSession();
	
		Transaction transaction = session.beginTransaction();

		// insert data into database
		Student student = new Student();
		student.setName("Pranjali");
		student.setCity("pune");
		student.setMobile("9595972678");
		session.save(student);
		transaction.commit();
		session.close();
		System.out.println("Record saved successfully.");

	}

}
