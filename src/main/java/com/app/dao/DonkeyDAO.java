package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.app.model.Donkey;
import com.app.service.HibernateService;

@Service
public class DonkeyDAO {

	public void create(Donkey donkey) {
		
		SessionFactory sessionFactory = HibernateService.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(donkey);
		
		tx.commit();
	}
	
	public Donkey get(int id) {
		
		Session session = HibernateService.getSessionFactory().openSession();
		Donkey d = (Donkey) session.load(Donkey.class, id);
		return d;
	}

}
