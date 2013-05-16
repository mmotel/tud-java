package com.example.shdemo.service.ro;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.ro.Ryba;


@Component
@Transactional
public class RybyManagerImpl implements IRybyManager {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addRyba(Ryba ryba) {
		ryba.setId(null);
		sessionFactory.getCurrentSession().persist(ryba);
	}

	@Override
	public void rmRyba(Ryba ryba) {
		sessionFactory.getCurrentSession().delete(ryba);
		
	}

	@Override
	public void editRyba(Ryba ryba) {
		sessionFactory.getCurrentSession().merge(ryba);
		
	}

	@Override
	public Ryba getRybaById(Ryba ryba) {
		return (Ryba) sessionFactory.getCurrentSession().get(Ryba.class , ryba.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ryba> getAllRyby() {
		return sessionFactory.getCurrentSession().getNamedQuery("Ryba.getAll").list();
	}

	@Override
	public void rmAllRyby() {
		sessionFactory.getCurrentSession().getNamedQuery("Ryba.rmAll");
		
	}
	
}
