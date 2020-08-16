package com.duong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duong.dao.ProductDAO;
import com.duong.entity.Sanpham;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void insertProduct(Sanpham sp) throws Exception {
		Session session = sessionFactory.openSession();
		session.save(sp);
		session.flush();
		session.close();
	}

	@Override
	public void updateProduct(Sanpham sp) throws Exception {
		Session session = sessionFactory.openSession();
		session.update(sp);
		session.flush();
		session.close();
	}

	@Override
	public void deleteProductByMaSp(String maSp) throws Exception {
		Session session = sessionFactory.openSession();
		Sanpham sp = getProuctByMaSp(maSp);
		session.delete(sp);
		session.flush();
		session.close();
	}

	@Override
	public Sanpham getProuctByMaSp(String maSp) throws Exception {
		Session session = sessionFactory.openSession();
		Sanpham sp = (Sanpham) session.get(Sanpham.class, maSp);
		session.close();
		return sp;
	}

	@Override
	public List<Sanpham> getAllProduct() throws Exception {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Sanpham.class);
		return criteria.list();
	}

}
