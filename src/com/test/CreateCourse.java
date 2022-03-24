package com.test;

import org.hibernate.Session;

import com.entity.Course;
import com.entity.Student;
import com.util.HibernateUtil;

public class CreateCourse {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Creating new Course");

//		Course course = new Course("Algebra", "High");
//		session.save(course);

		Course c1 = new Course("Psychology", "AP");
		session.save(c1);
		Course c2 = new Course("Biology", "Middle School");
		session.save(c2);
		
		Course c3 = new Course("Physics", "High");
		session.save(c3);
		Course c4 = new Course("Chemistry", "AP");
		session.save(c4);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
