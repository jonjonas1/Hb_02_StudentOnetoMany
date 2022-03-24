package com.test;

import org.hibernate.Session;

import com.entity.Course;
import com.util.HibernateUtil;

public class GetStudentCourse {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Course c2 = session.get(Course.class, 3);

		System.out.println("course id: " + c2);
		// Bi-directional, below c2 course object getting student details
		System.out.println("the student: " + c2.getStudent());

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
