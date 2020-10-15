package com.duong.dao.impl;

import java.util.List;

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
	//true - da giao / false - chua giao
	@Override
	public List<DonHang> getOrderByStatus(boolean status) throws Exception {
		Session session = sessionFactory.openSession();
		String hql = "FROM DonHang D WHERE D.tinhTrang = :tt";
		Query query = session.createQuery(hql);
		query.setParameter("tt", status);
		List<DonHang> dhs = query.list();
		session.close();
		
		return dhs;
	}
	@Override
	public int getIdDonHang(NguoiDung nd) throws Exception {
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
