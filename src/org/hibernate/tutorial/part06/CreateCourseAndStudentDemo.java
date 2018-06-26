package org.hibernate.tutorial.part06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class CreateCourseAndStudentDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction();
			
			// Create a course
			Course c1 = new Course("Complete Java Course - Beginner to Master");
			
			// save the course
			System.out.println("\nSaving the course . . . ");
			session.save(c1);
			System.out.println("Saved course: " + c1);	
			
			// create the students
			Student std1 = new Student("Tutku", "Ince", "incetutku@gmail.com");
			Student std2 = new Student("Emin", "Koklu", "kokluemin@gmail.com");

			//  add students to the course
			c1.addStudent(std1);
			c1.addStudent(std2);
			
			// save the students
			System.out.println("\nSaving students . . . ");
			session.save(std1);
			session.save(std2);
			
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
		
	}
}
