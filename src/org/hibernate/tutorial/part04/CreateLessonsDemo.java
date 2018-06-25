package org.hibernate.tutorial.part04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.tutorial.util.HibernateUtil;

public class CreateLessonsDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			int id = 1;
			Teacher teacher = session.get(Teacher.class, id);

			Lesson l1 = new Lesson("Spring Framework 5 Masterclass");

			Lesson l2 = new Lesson("Data Structures and Algorithms: Deep Dive Using Java");

			Lesson l3 = new Lesson("SOLID Software Architecture: Complete Guide with Coding Examples");

			System.out.println("teacher: " + teacher);
			
			teacher.add(l1);
			teacher.add(l2);
			teacher.add(l3);
			
			session.save(l1);
			session.save(l2);
			session.save(l3);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
