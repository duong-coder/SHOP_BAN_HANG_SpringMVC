package com.duong.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.duong.dao.OrderDAO;
import com.duong.entity.DonHang;
import com.duong.entity.NguoiDung;

@Repository
public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(DonHang donHang) throws Exception {
		Session session = sessionFactory.openSession();
		session.save(donHang);
		session.flush();
		session.close();
		
	}
	
	@Override
	public int getIdDonHang(NguoiDung nd) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT Max(D.maHD) FROM DonHang D WHERE D.nguoiDung = :nd";
		Query query = session.createQuery(hql);
		query.setParameter("nd", nd);
		int maHD = (int) query.uniqueResult();
		session.flush();
		session.close();
		
		return maHD;
	}
}
