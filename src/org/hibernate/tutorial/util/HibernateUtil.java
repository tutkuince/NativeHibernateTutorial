package org.hibernate.tutorial.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.tutorial.part02.Student;

public class HibernateUtil<T> {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			// Create registry builder
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

			// Hibernate settings equivalent to hibernate.cfg.xml's properties
			Map<String, String> settings = new HashMap<>();
			
			// JDBC Database connection settings
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "123456.");
			
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect"); // Select our SQL dialect
			settings.put(Environment.POOL_SIZE, "1"); // JDBC connection pool settings
			
			settings.put(Environment.SHOW_SQL, "true");	// Echo the SQL stdout
			
			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");	// Set the current session context
			settings.put(Environment.HBM2DDL_AUTO, "create");

			// Apply settings
			registryBuilder.applySettings(settings);

			// Create registry
			registry = registryBuilder.build();

			// Create MetadataSources
			MetadataSources metadataSources = new MetadataSources(registry).addAnnotatedClass(Student.class);	

			// Create MetaData
			Metadata metaData = metadataSources.buildMetadata();

			// Create SessionFactory
			sessionFactory = metaData.buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
