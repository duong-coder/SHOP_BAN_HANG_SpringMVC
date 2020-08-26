package com.duong.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.duong.model.ColorDTO;

public interface ColorService {
	List<ColorDTO> getAllColor() throws HibernateException;
}
