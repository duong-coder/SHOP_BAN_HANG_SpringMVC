package com.duong.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.duong.entity.ChiTietSanPham;
import com.duong.entity.SanPham;

public interface ProductDetailDAO {
	
	void insertProductDetail(ChiTietSanPham ctsp) throws HibernateException;
	
	void updateProductDetail(ChiTietSanPham ctspOld, ChiTietSanPham ctspNew) throws HibernateException;
	
	void deleteProductDetail(String maSP, int maMau, int maSize) throws HibernateException;
	
	ChiTietSanPham getProductDetail(String maSP, int maMau, int maSize) throws HibernateException;
	
	ChiTietSanPham getProductDetail(ChiTietSanPham ctsp) throws HibernateException;
	
	int getAmountProductDetail(String maSP, int maMau, int maSize) throws HibernateException;
	
//	List<ChiTietSanPham> getAllProductDetailByIdSP(SanPham sp) throws HibernateException;
	
	List<ChiTietSanPham> getAllProductDetail() throws HibernateException;

	List<ChiTietSanPham> getAllProductDetailByMaSP(String maSP) throws HibernateException;
}
