package com.test;

import org.hibernate.Session;

import com.entity.Course;
import com.util.HibernateUtil;

public class DeletingCourse {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Deleting course");

		Course c2 = session.get(Course.class, 4);

		System.out.println("course id: " + c2);
		System.out.println("the student: " + c2.getStudent());

		// old. deleting c2 object from course will also delete student info, because
		// cascadeType.ALL
		// since changed casscadeType. to others remove the associated object
		// break bi-directional link
		c2.getStudent().setCourse(null);

		if (c2 != null) {
			System.out.println("Deleting course only: " + c2);
			session.delete(c2);
		}

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
