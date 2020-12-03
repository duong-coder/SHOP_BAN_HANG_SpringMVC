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
	public void updateProductDetail(ChiTietSanPham ctspOld, ChiTietSanPham ctspNew) throws HibernateException {
		System.out.println("New: " + ctspNew.getMauSac().getMaMau()
				+ "// " + ctspNew.getSizeSanPham().getMaSize()
				+ "//" + ctspNew.getSoLuong());
		System.out.println("Old: " + ctspNew.getMauSac().getMaMau()
				+ "// " + ctspNew.getSizeSanPham().getMaSize()
				+ "//" + ctspOld.getSanPham().getMaSP());
		
		Session session = sessionFactory.openSession();
		String hql = "update ChiTietSanPham as C"
				+ " set C.mauSac = :mausacN,"
				+ " C.sizeSP = :sizespN,"
				+ " C.soLuong = :soLuongN"
				+ " where"
				+ " C.sanPham = :sanphamO and"
				+ " C.mauSac = :mausacO and"
				+ " C.sizeSP =:sizespO";
		Query query = session.createQuery(hql);
		query.setParameter("mausacN", ctspNew.getMauSac());
		query.setParameter("sizespN", ctspNew.getSizeSanPham());
		query.setParameter("soLuongN", ctspNew.getSoLuong());

//		query.setParameter("sanphamO", ctspOld.getSanPham());
		query.setParameter("mausacO", ctspOld.getMauSac());
		query.setParameter("sizespO", ctspOld.getSizeSanPham());

		query.executeUpdate();
		session.flush();
		session.close();
	}

	@Override
	public void deleteProductDetail(String maSP, int maMau, int maSize) throws HibernateException {
		ChiTietSanPham ctsp = getProductDetail(maSP, maMau, maSize);
		Session session = sessionFactory.openSession();
		session.delete(ctsp);
		session.flush();
		session.close();
	}
	
	@Override
	public ChiTietSanPham getProductDetail(String maSP, int maMau, int maSize) throws HibernateException {
		Session session = sessionFactory.openSession();
		SanPham sp = new SanPham();
		sp.setMaSP(maSP);
		MauSac mauSac = new MauSac();
		mauSac.setMaMau(maMau);
		SizeSanPham sizeSanPham = new SizeSanPham();
		sizeSanPham.setMaSize(maSize);
		
		String hql = "from ChiTietSanPham as C where C.sanPham = :sanpham and C.mauSac = :mausac and C.sizeSP =:sizesp";
		Query query = session.createQuery(hql);
		query.setParameter("sanpham", sp);
		query.setParameter("mausac", mauSac);
		query.setParameter("sizesp", sizeSanPham);
		ChiTietSanPham ctsp = (ChiTietSanPham) query.uniqueResult();
		
		return ctsp;
	}
	
	@Override
	public ChiTietSanPham getProductDetail(ChiTietSanPham ctsp) throws HibernateException {
		Session session = sessionFactory.openSession();
		String hql = "from ChiTietSanPham as C where C.sanPham = :sanpham and C.mauSac = :mausac and C.sizeSP =:sizesp";
		Query query = session.createQuery(hql);
		query.setParameter("sanpham", ctsp.getSanPham());
		query.setParameter("mausac", ctsp.getMauSac());
		query.setParameter("sizesp", ctsp.getSizeSanPham());
		ChiTietSanPham ctspQuery = (ChiTietSanPham) query.uniqueResult();
		
		return ctspQuery;
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
	public  List<ChiTietSanPham> getAllProductDetailByMaSP(String maSP) throws HibernateException {
		SanPham sp = new SanPham();
		sp.setMaSP(maSP);
		
		Session session = sessionFactory.openSession();
		String hql = "from ChiTietSanPham as CTSP where CTSP.sanPham = :sanpham";
		Query query = session.createQuery(hql);
		query.setParameter("sanpham", sp);
		List<ChiTietSanPham> ctsps = (List<ChiTietSanPham>) query.list();
		session.close();
		return ctsps;
	}
	
	@Override
	public List<ChiTietSanPham> getAllProductDetail() throws HibernateException {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ChiTietSanPham.class);
		List<ChiTietSanPham> ctsps = criteria.list();
		session.close();
		return ctsps;
	}
	
}
