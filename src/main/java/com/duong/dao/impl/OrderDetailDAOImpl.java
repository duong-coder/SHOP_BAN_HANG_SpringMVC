package com.duong.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duong.dao.OrderDetailDAO;
import com.duong.entity.ChiTietDonHang;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(ChiTietDonHang cTDH) throws Exception {
		Session session = sessionFactory.openSession();
		session.save(cTDH);
		session.flush();
		session.close();
		
	}
}
