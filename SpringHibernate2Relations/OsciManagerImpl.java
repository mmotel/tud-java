package com.example.shdemo.service.ro;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.ro.Osc;
import com.example.shdemo.domain.ro.Ryba;

@Component
@Transactional
public class OsciManagerImpl implements IOsciManager {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addOsc(Osc osc) {
		osc.setId(null);
		sessionFactory.getCurrentSession().persist(osc);
		
	}

	@Override
	public void rmOsc(Osc osc) {
		sessionFactory.getCurrentSession().delete(osc);
		
	}

	@Override
	public void editOsc(Osc osc) {
		sessionFactory.getCurrentSession().merge(osc);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Osc> getAllOsci() {
		return sessionFactory.getCurrentSession().getNamedQuery("Osc.getAll").list();
	}

	@Override
	public Osc getOscById(Osc osc) {
		return (Osc) sessionFactory.getCurrentSession().get(Osc.class, osc.getId());
	}

	@Override
	public List<Osc> getOsciByRyba(Ryba ryba) {
		Ryba r = (Ryba) sessionFactory.getCurrentSession().get(Ryba.class, ryba.getId());
		return r.getOsci();
	}

	@Override
	public void addOscToRyba(Osc osc, Ryba ryba) {
		Ryba r = (Ryba) sessionFactory.getCurrentSession().get(Ryba.class, ryba.getId());
		r.getOsci().add(osc);
	}

}
