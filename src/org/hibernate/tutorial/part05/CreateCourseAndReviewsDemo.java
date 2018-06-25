package org.hibernate.tutorial.part05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class CreateCourseAndReviewsDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			// Start transaction
			session.beginTransaction();

			// Create a course
			Course c1 = new Course("Complete Java Course - Beginner to Master");

			// Add some reviews
			c1.addReview(new Review("Great course... I loved it!"));
			c1.addReview(new Review("Great! Good content."));
			c1.addReview(new Review("Average. "));
			c1.addReview(new Review("What a dumb course, you are an idiot!"));

			// Save the course
			session.save(c1);
			
			System.out.println(c1);
			System.out.println(c1.getReviews());
			
			// Commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
