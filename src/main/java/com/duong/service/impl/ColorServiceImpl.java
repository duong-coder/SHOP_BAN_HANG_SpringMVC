package com.duong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duong.dao.ColorDAO;
import com.duong.entity.MauSac;
import com.duong.model.ColorDTO;
import com.duong.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService{
	
	@Autowired
	private ColorDAO colorDAO;
	
	@Override
	public List<ColorDTO> getAllColor() throws HibernateException {
		List<MauSac> mauSacs = colorDAO.getAllColor();
		List<ColorDTO> colorDTOs = new ArrayList<ColorDTO>();
		
		mauSacs.forEach((ms) -> {
			ColorDTO c = new ColorDTO();
			c.setId(ms.getMaMau());
			c.setColor(ms.getTenMau());
			
			colorDTOs.add(c);
		});
		return colorDTOs;
	}

}
