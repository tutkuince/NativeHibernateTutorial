package org.hibernate.tutorial.part04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.tutorial.util.HibernateUtil;

public class LazyLoadingDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			session.beginTransaction();
			int id = 1;
			Query<Teacher> query = session.createQuery(
					"select t from Teacher t " + "JOIN FETCH t.lessons " + "where t.id=:teacherId", Teacher.class);

			// set parameter on query
			query.setParameter("teacherId", id);

			// execute query and get teacher
			Teacher teacher = query.getSingleResult();

			System.out.println("Teacher: " + teacher);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
