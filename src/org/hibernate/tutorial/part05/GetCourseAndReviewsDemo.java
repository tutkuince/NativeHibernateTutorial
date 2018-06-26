package org.hibernate.tutorial.part05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class GetCourseAndReviewsDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			// Start transaction
			session.beginTransaction();
			
			// get the course
			int id = 1;
			Course course = session.get(Course.class, id);
			
			// print the course
			System.out.println("Course: " + course);
			
			// print the course reviews
			course.getReviews().forEach(System.out::println);
			
			// commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
