package com.duong.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duong.dao.CategoryDAO;
import com.duong.entity.DanhMuc;
import com.duong.entity.SanPham;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertCategory(DanhMuc danhMuc) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(DanhMuc danhMuc) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategoryById(int id) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DanhMuc getCategory(int id) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SanPham> getAllProductByCategory(int id) throws HibernateException {
		Session session = sessionFactory.openSession();
		DanhMuc danhMuc =  (DanhMuc) session.get(DanhMuc.class, id);
		List<SanPham> phams = danhMuc.getSanPhams();
		session.close();
		return phams;
	}

	@Override
	public List<DanhMuc> getAllCategory() throws HibernateException {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(DanhMuc.class);
		List<DanhMuc> danhMucs = criteria.list();
		session.close();
		return danhMucs;
	}

}
