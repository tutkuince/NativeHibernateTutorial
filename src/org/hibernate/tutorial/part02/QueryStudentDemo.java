package org.hibernate.tutorial.part02;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class QueryStudentDemo {
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
			
			// Query Students
			List<Student> studentList = session.createQuery("from Student", Student.class).getResultList();
			
			// List<Student> studentList = session.createQuery("from Student s where s.lastName='Ince'", Student.class).getResultList();
			
			// Display Students
			studentList.forEach(System.out::println);
			
			session.close();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
