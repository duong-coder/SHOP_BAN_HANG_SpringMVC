package com.duong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duong.dao.SizeDAO;
import com.duong.entity.SizeSanPham;

@Repository
public class SizeDAOImpl implements SizeDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<SizeSanPham> getAllSizeSanPham() throws HibernateException {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(SizeSanPham.class);
		List<SizeSanPham> sizeSanPhams = criteria.list(); 
		session.close();
		return sizeSanPhams;
	}
}
