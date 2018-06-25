package org.hibernate.tutorial.part04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class EagerLoadingDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			int id = 1;
			session.beginTransaction();
			long start = System.currentTimeMillis();
			Teacher teacher = session.get(Teacher.class, id);

			teacher.getLesson().forEach(System.out::println);

			session.getTransaction().commit();
			long end = System.currentTimeMillis();

			System.out.println("Elapsed time: " + (end - start)); // Elapsed time: 47
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
