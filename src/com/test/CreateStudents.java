package com.test;

import org.hibernate.Session;

import com.entity.Student;
import com.util.HibernateUtil;
import com.util.TestJdbc;

public class CreateStudents extends TestJdbc {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Creating new Students");

		Student st1 = new Student("William", "Richard");
		session.save(st1);
		Student st2 = new Student("Joseph", "Andrew");
		session.save(st2);
		Student st3 = new Student("Richard", "William");
		session.save(st3);
		Student st4 = new Student("Daniel", "Anthony");
		session.save(st4);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
