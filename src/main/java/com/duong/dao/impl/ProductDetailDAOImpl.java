package com.duong.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.duong.dao.ProductDetailDAO;
import com.duong.entity.ChiTietSanPham;
import com.duong.entity.MauSac;
import com.duong.entity.SanPham;
import com.duong.entity.SizeSanPham;

@Repository
@Transactional
public class ProductDetailDAOImpl implements ProductDetailDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertProductDetail(ChiTietSanPham ctsp) throws HibernateException {
		Session session = sessionFactory.openSession();
		session.save(ctsp);
		session.flush();
		session.close();
	}

	@Override
	public void updateProductDetail(ChiTietSanPham ctsp) throws HibernateException {
		Session session = sessionFactory.openSession();
		session.update(ctsp);
		session.flush();
		session.close();
	}

	@Override
	public void deleteProductDetail(int idctsp) throws HibernateException {
		ChiTietSanPham ctsp = getProductDetailByIdCT(idctsp);
		Session session = sessionFactory.openSession();
		session.delete(ctsp);
		session.flush();
		session.close();
	}
	
	@Override
	public ChiTietSanPham getProductDetailByIdCT(int id) throws HibernateException {
		Session session = sessionFactory.openSession();
		ChiTietSanPham ctsp = (ChiTietSanPham) session.get(ChiTietSanPham.class, id);
		session.close();
		
		return ctsp;
	}
	
	@Override
	public int getAmountProductDetail(String maSP, int maMau, int maSize) throws HibernateException {
		Session session = sessionFactory.openSession();
		SanPham sp = new SanPham();
		sp.setMaSP(maSP);
		MauSac mauSac = new MauSac();
		mauSac.setMaMau(maMau);
		SizeSanPham sizeSanPham = new SizeSanPham();
		sizeSanPham.setMaSize(maSize);
		
		String hql = "select C.soLuong from ChiTietSanPham as C where C.sanPham = :sanpham and C.mauSac = :mausac and C.sizeSP =:sizesp";
		Query query = session.createQuery(hql);
		query.setParameter("sanpham", sp);
		query.setParameter("mausac", mauSac);
		query.setParameter("sizesp", sizeSanPham);
		int soLuong = (int) query.uniqueResult();

		return soLuong;
	}
	
	@Override
	public List<ChiTietSanPham> getAllProductDetail() throws HibernateException {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ChiTietSanPham.class);
		List<ChiTietSanPham> ctsps = criteria.list();
		
		return ctsps;
	}
	
}
