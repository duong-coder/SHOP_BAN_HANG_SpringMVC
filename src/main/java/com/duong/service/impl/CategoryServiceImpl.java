package com.duong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duong.dao.CategoryDAO;
import com.duong.entity.DanhMuc;
import com.duong.entity.SanPham;
import com.duong.model.CategoryDTO;
import com.duong.model.ProductDTO;
import com.duong.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public void insertCategory(CategoryDTO categoryDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(CategoryDTO categoryDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategoryById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DanhMuc getCategory(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> getAllProductByCategory(int id) throws Exception {
		List<SanPham> sanPhams = categoryDAO.getAllProductByCategory(id);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanPhams.forEach((sp) ->{
			ProductDTO dto = new ProductDTO();
			dto.setMaSp(sp.getMaSP());
			dto.setTenSp(sp.getTenSP());
			dto.setMoTa(sp.getMoTa());
			dto.setGia(sp.getGia());
			dto.setTenAnh(sp.getAnhMoTa());
			
			productDTOs.add(dto);
		});
		return productDTOs;
	}

	@Override
	public List<CategoryDTO> getAllCategory() throws Exception {
		List<DanhMuc> danhMucs = categoryDAO.getAllCategory();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		danhMucs.forEach((dm) ->{
			CategoryDTO dto = new CategoryDTO();
			dto.setId(dm.getMaDanhMuc());
			dto.setName(dm.getTenDanhMuc());
			dto.setImage(dm.getHinhAnh());
			
			categoryDTOs.add(dto);
		});
		return categoryDTOs;
	}

}
