package org.hibernate.tutorial.part02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class CreateStudentDemo {
	public static void main(String[] args) {
		// Create SessionFactory 
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// Create a student object
			Student student = new Student("Tutku", "Ince", "incetutku@gmail.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the student object
			session.save(student);
			
			// Commit transaction
			session.getTransaction().commit();
			
			// Close the session
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			HibernateUtil.shutdown();
		}
		
		
	}
}
