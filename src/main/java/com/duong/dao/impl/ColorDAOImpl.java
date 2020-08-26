package com.duong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duong.dao.ColorDAO;
import com.duong.entity.MauSac;

@Repository
public class ColorDAOImpl implements ColorDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MauSac> getAllColor() throws HibernateException {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(MauSac.class);
		List<MauSac> mauSacs = criteria.list();
		session.close();
		return mauSacs;
	}

}
