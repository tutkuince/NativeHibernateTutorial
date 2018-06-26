package org.hibernate.tutorial.part06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class AddCoursesForTutku {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id = 1;
			Student student = session.get(Student.class, id);
			
			System.out.println("\nLoaded student: " + student);
			System.out.println("\nCourses: " + student.getCourses());
			
			// create more courses
			Course c1 = new Course("Let's learn Spring Framework");
			Course c2 = new Course("Beginner to Master React JS");
			Course c3 = new Course("Learn Java in 30 minutes");
			
			// add student to course
			c1.addStudent(student);
			c2.addStudent(student);
			c3.addStudent(student);
			
			// save courses
			System.out.println("\nSaving courses . . . ");
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
