package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

// for update data from database
public class Test3 {
	public static void main(String[] args) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		// update data from database
		Student student = session.get(Student.class, 2);
		student.setCity("Banglore");
		session.update(student);
		transaction.commit();
		session.close();
		System.out.println("Record Updated Successfully....");

	}
}
