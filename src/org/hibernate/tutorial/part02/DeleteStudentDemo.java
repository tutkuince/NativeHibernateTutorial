package org.hibernate.tutorial.part02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// Create 3 student object
			Student std1 = new Student("Tutku", "Ince", "incetutku@gmail.com");
			Student std2 = new Student("Emin", "Koklu", "eminkoklu@gmail.com");
			Student std3 = new Student("Ugur", "Batikan", "batikanugur@gmail.com");
			
			// Start a transaction 
			session.beginTransaction();
			
			// Save the student objects
			session.save(std1);
			session.save(std2);
			session.save(std3);
			
			// Commit transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student student = session.get(Student.class, 1);
			session.delete(student);
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
