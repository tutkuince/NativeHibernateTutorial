package org.hibernate.tutorial.part03.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class CreateInstructorDemo {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// Create the Instructor object
			Instructor instructor = new Instructor("Tutku", "Ince", "incetutku@gmail.com");

			session.beginTransaction();

			session.save(instructor);

			session.getTransaction().commit();
			
			System.out.println("Saved Instructor: " + instructor);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
