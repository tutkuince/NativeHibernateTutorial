package org.hibernate.tutorial.part03.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class GetInstructorCoursesDemo {
	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = HibernateUtil.getSessionFactory();

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// get a course
			int id = 1;
			Course tempCourse = session.get(Course.class, id);
			
			// delete the course
			System.out.println("Deleting course: " + tempCourse);
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
