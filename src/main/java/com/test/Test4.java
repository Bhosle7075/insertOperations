package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

//for delete data from database
public class Test4 {
	public static void main(String[] args) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		// delete data from database
		Student student = session.get(Student.class, 6);
		session.delete(student);
		transaction.commit();
		session.close();
		System.out.println("Record Deleted Successfully....");

	}

}
