package com.duong.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.duong.entity.MauSac;

public interface ColorDAO {
	List<MauSac> getAllColor() throws HibernateException;
}
