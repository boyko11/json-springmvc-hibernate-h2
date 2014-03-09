package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.app.model.Village;
import com.app.service.HibernateService;

@Service
public class VillageDAO {

	public Village getVillage(int id) {
		
		Session session = HibernateService.getSessionFactory().openSession();
		Village village = (Village) session.load(Village.class, id);
		return village;
	}
	
	public void create(Village village) {
		
		SessionFactory sessionFactory = HibernateService.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(village);
		
		tx.commit();
	}
}
