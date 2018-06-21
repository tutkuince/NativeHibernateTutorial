package org.hibernate.tutorial.test;

import org.hibernate.Session;
import org.hibernate.tutorial.util.HibernateUtil;

public class TestHibernateConn {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		// Check database version
		String sql = "select version()";

		String result = (String) session.createNativeQuery(sql).getSingleResult();
		System.out.println(result);

		session.getTransaction().commit();
		session.close();

		HibernateUtil.shutdown();

	}
}
