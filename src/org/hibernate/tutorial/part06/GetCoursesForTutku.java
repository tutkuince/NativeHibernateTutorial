package org.hibernate.tutorial.part06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class GetCoursesForTutku {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int id = 1;
			Student student = session.get(Student.class, id);
			
			System.out.println("\nLoaded student: " + student);
			System.out.println("\nCourses: " + student.getCourses());
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
