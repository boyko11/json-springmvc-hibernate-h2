package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.app.model.Person;
import com.app.service.HibernateService;

@Service
public class PersonDAO {
	
	static {
		SessionFactory sessionFactory = HibernateService.getSessionFactory();
		
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
		
		session.save(p1);
		session.save(p2);
		
		System.out.println(p1.getId());
		System.out.println(p2.getId());
		System.out.println("------------------------------------------------");
		
		tx.commit();
	}
	
	public void create(Person person) {
		
		SessionFactory sessionFactory = HibernateService.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(person);
		
		tx.commit();
	}
	
	public Person get(int id) {
		
		Session session = HibernateService.getSessionFactory().openSession();
		Person p = (Person) session.load(Person.class, id);
		return p;
	}

}
