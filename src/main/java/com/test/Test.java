package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

	public static void main(String[] args) {
//		Test.addStudent();
//		Test.readStudent();
		Test.deleteStudent();

	}

	public static void addStudent() {
		Session session = HibernateUtils.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		// insert data into database
		Student student = new Student();

		student.setName("Devraj");
		student.setCity("Chennai");
		student.setMobile("8540090005");

		session.save(student);
		transaction.commit();

		session.close();
		System.out.println("Record saved successfully.");
	}

	public static void readStudent() {
		Session session = HibernateUtils.getSessionFactory().openSession();

		// insert data into database
		Student student = session.get(Student.class, 2);
		if (student != null) {
			System.out.println("Student: " + student.getName() + ", " + student.getCity() + ", " + student.getMobile());
		} else {
			System.out.println("Student not found.");
		}
		session.close();
	}

	public static void deleteStudent() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		// insert data into database
		Student student = session.get(Student.class, 2);
		if (student != null) {
			System.out.println("Student: " + student.getName() + ", " + student.getCity() + ", " + student.getMobile());
			session.delete(student);
			
			transaction.commit();
			System.out.println("Record deleted successfully");
			
		} else {
			System.out.println("Student not found.");
			transaction.rollback();
		}
		session.close();
	}
}
