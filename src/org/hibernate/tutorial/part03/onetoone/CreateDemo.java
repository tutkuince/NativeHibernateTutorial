package org.hibernate.tutorial.part03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class CreateDemo {
	public static void main(String[] args) {
		// Create SessionFactory
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		// Create the objects
		Instructor instructor = new Instructor("Tutku", "Ince", "incetutku@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.muditasoft.com", "Love to code!");
		
		Instructor instructor2 = new Instructor("Emin", "Koklu", "kasaremin@gmail.com");

		InstructorDetail instructorDetail2 = new InstructorDetail("http://www.gramgames.com", "Love to attack!");
		
		// Associate the objects
		instructor.setInstructorDetail(instructorDetail);
		instructor2.setInstructorDetail(instructorDetail2);
		
		// Start a transaction
		session.beginTransaction();
		
		// Save the instructor
		// Note: this will ALSO save the "details" object because of "CascadeType.ALL"
		System.out.println("Saving instructor: " + instructor);
		session.save(instructor);
		session.save(instructor2);
		
		// Commit transaction
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}
}
