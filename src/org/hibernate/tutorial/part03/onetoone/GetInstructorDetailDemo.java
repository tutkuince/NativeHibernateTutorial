package org.hibernate.tutorial.part03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class GetInstructorDetailDemo {
	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();

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
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}
}
