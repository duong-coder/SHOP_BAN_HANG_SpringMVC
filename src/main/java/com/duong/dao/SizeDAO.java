package com.duong.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.duong.entity.SizeSanPham;

public interface SizeDAO {
	List<SizeSanPham> getAllSizeSanPham() throws HibernateException;
}
