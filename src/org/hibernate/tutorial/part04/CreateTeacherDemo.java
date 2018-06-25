package org.hibernate.tutorial.part04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class CreateTeacherDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Teacher teacher = new Teacher("Tutku", "Ince", "incetutku@gmail.com");
			session.beginTransaction();
			
			session.save(teacher);
			
			session.getTransaction().commit();
			System.out.println("Teacher: " + teacher);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
