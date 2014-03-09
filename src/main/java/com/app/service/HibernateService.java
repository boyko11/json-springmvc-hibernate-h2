package com.app.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.app.model.Person;
import com.app.model.Village;


public class HibernateService {

	private static SessionFactory sessionFactory;

	private static void init() {

		Configuration configuration = new Configuration();

		configuration.setProperty("hibernate.connection.driver_class",
				"org.h2.Driver");
		configuration.setProperty("hibernate.dialect",
				"org.hibernate.dialect.H2Dialect");
		configuration.setProperty("hibernate.connection.url",
				"jdbc:h2:mem:persondb");
		configuration.setProperty("hibernate.connection.username", "sa");
		configuration.setProperty("hibernate.connection.password", "");
		configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.format_sql", "true");

		configuration.addPackage("com.app.model")
			.addAnnotatedClass(Person.class)
			.addAnnotatedClass(Village.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	private static void bootstrapData() {
			
		System.out.println("Bootstrap started------------------------------------------------");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Person p1 = new Person();
		p1.setAge(11);
		p1.setFirstName("1111");
		p1.setLastName("L-11111");
		
		Person p2 = new Person();
		p2.setAge(22);
		p2.setFirstName("2222");
		p2.setLastName("L-2222");
		
		//session.save(p1);
		//session.save(p2);
		
		Village v1 = new Village();
		v1.setName("Boykovino");
		p1.setVillage(v1);
		p2.setVillage(v1);
		v1.addToPersons(p1);
		v1.addToPersons(p2);
		session.save(v1);
		
		System.out.println("Created persons: " + p1.getId() + " " + p2.getId());
		System.out.println(p2.getId());
		
		Village v2 = new Village();
		v2.setName("Seraphimovo");
		session.save(v2);
		
		System.out.println("Created villages: " + v1.getId() + " " + v2.getId());
		tx.commit();
		
		System.out.println("Testing saved village: ");
		Village savedVillage = (Village) session.get(Village.class, v1.getId());
		for(Person p : savedVillage.getPersons()) {
			System.out.println(p.getFirstName());
			System.out.println(p.getId());
		}
		
		System.out.println("Testing saved person: ");
		Person savedPerson = (Person) session.get(Person.class,p1.getId());
		System.out.println(savedPerson.getFirstName());
		System.out.println(savedPerson.getVillage().getName());
		
		
		System.out.println("Bootstrap finished------------------------------------------------");
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			init();
		}
		return sessionFactory;
	}
	
	static {
		init();
		bootstrapData();
	}

}
