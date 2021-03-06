package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.app.model.Person;
import com.app.service.HibernateService;

@Service
public class PersonDAO {
	
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
