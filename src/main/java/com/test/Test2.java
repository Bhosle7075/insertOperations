package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test2 {

	public static void main(String[] args) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student s1=new Student(123,"kailas","banglore","738532");
		
		Student s2=new Student(134,"prashant","pune","44444");
		
		Student s3=new Student(145,"dahiwal","bombay","333333");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		transaction.commit();
		
		session.close();
		System.out.println("save success");
	}
	
}
