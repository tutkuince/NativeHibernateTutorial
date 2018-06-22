package org.hibernate.tutorial.part03.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class DeleteCourseDemo {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// get instructor from database
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Instructor: " + instructor);
			
			// get courses for the instructor
			instructor.getCourses().forEach(System.out::println);
			
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
