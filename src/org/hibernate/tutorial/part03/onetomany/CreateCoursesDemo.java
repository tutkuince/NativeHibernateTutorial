package org.hibernate.tutorial.part03.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class CreateCoursesDemo {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// Create the courses object
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor from database
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			// create some courses
			Course course1 = new Course("Air Guitar - Ultimate Guide");
			Course course2 = new Course("Java SE - Masterclass");
			
			// add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			// save the courses
			session.save(course1);
			session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
