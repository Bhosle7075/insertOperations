package com.test;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

//for select/read all data from database
public class Test2 {

	public static void main(String[] args) {

		Session session = HibernateUtils.getSessionFactory().openSession();
// select data from database
		Query query = session.createQuery("from Student");
		List<Student> stuList = query.list();
		for (Student student : stuList) {
			System.out.println("ID=" + student.getId());
			System.out.println("City=" + student.getCity());
			System.out.println("Mobile=" + student.getMobile());
			System.out.println("Name=" + student.getMobile());

		}
		session.close();

	}
}
