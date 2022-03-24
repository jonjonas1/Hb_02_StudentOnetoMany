package com.test;

import org.hibernate.Session;

import com.entity.Course;
import com.entity.Review;
import com.util.HibernateUtil;

public class WriteReviewToCourse {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Write a review to course");

		Course cr = session.get(Course.class, 2);
//		Course cr = new Course("AP Computer","High");
		cr.addReview(new Review("Biology is awesome"));
		cr.addReview(new Review("so easy class"));
		cr.addReview(new Review("every week is test"));
		
		System.out.println("course name: "+cr.getName());
		System.out.println(cr.getReview());
		session.save(cr);

//		Review review = session.get(Review.class, 1);
//		session.delete(review);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
