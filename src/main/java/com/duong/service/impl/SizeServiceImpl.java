package com.duong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duong.dao.SizeDAO;
import com.duong.entity.SizeSanPham;
import com.duong.model.SizeDTO;
import com.duong.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService{
	
	@Autowired
	private SizeDAO sizeDAO;
	
	@Override
	public List<SizeDTO> getAllSizeSanPham() throws HibernateException {
		List<SizeDTO> sizeDTOs  = new ArrayList<SizeDTO>();
		List<SizeSanPham> sizeSanPhams = sizeDAO.getAllSizeSanPham();
		sizeSanPhams.forEach((size) -> {
			SizeDTO sizeDTO = new SizeDTO();
			sizeDTO.setId(size.getMaSize());
			sizeDTO.setSize(size.getSize());
			
			sizeDTOs.add(sizeDTO);
		});
		
		return sizeDTOs;
	}
}
