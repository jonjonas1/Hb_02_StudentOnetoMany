package com.test;

import org.hibernate.Session;

import com.entity.Course;
import com.entity.Student;
import com.util.HibernateUtil;

public class AsigningCourse {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Assigning course to Student");

		Student st = session.get(Student.class, 3);
		Course c = session.get(Course.class, 1);
		st.add(c);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
