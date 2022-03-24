package com.test;


import org.hibernate.Session;

import com.entity.Student;
import com.util.HibernateUtil;

public class DeleteStudent {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Deleting Student");

		Student s2 = session.get(Student.class, 5);

		System.out.println("student info: " + s2);
		System.out.println("student course: " + s2.getCourse());
		
		
		// if we delete student associated course also will be deleted because Student entity has 
		// because oneToOne annotation CascadeType.ALL in student.class to course
		if (s2 != null) {
			System.out.println("Deleting student only: " + s2);
			session.delete(s2);
		}

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");

	}

}
