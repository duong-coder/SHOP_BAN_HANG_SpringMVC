package com.duong.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.duong.entity.DanhMuc;
import com.duong.entity.SanPham;

public interface CategoryDAO {
	void insertCategory(DanhMuc danhMuc) throws HibernateException;
	
	void updateCategory(DanhMuc danhMuc) throws HibernateException;
	
	void deleteCategoryById(int id) throws HibernateException;
	
	DanhMuc getCategory(int id) throws HibernateException;
	
	List<SanPham> getAllProductByCategory(int id) throws HibernateException;
	
	List<DanhMuc> getAllCategory() throws HibernateException;
}
