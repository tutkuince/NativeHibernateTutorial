package org.hibernate.tutorial.part03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class ExceptionHandlingDemo {
	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();

		try {
			// Create Session
			Session session = factory.getCurrentSession();

			// Start a transaction
			session.beginTransaction();

			// get instructor detail by primary key / id
			int theId = 1;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			// Print the instructor detail
			System.out.println("Instructor detail: " + instructorDetail);

			// Print the associated instructor
			System.out.println("Instructor: " + instructorDetail.getInstructor());

			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}

	}
}
