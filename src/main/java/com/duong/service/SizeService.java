package com.duong.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.duong.model.SizeDTO;

public interface SizeService {
	List<SizeDTO> getAllSizeSanPham() throws HibernateException;
}
