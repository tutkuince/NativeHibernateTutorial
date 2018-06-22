package org.hibernate.tutorial.part03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class DeleteDemo {
	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		// Start a transaction
		session.beginTransaction();
		
		// get instructor by primary key / id
		int theId = 2;
		Instructor instructor = session.get(Instructor.class, theId);
		
		System.out.println("Found instructor: " + instructor);
		
		// Delete the instructor
		if(instructor != null) {
			System.out.println("Deleting: " + instructor);
			
			// Note: will ALSO delete associated "details" object because of CascadeType.ALL
			session.delete(instructor);
		}
		
		// Commit transaction
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}
}
