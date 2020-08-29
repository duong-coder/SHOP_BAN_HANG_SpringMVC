package com.duong.service;

import java.util.List;
import com.duong.entity.DanhMuc;
import com.duong.model.CategoryDTO;
import com.duong.model.ProductDTO;

public interface CategoryService {
	
	void insertCategory(CategoryDTO categoryDTO) throws Exception;
	
	void updateCategory(CategoryDTO categoryDTO) throws Exception;
	
	void deleteCategoryById(int id) throws Exception;
	
	DanhMuc getCategory(int id) throws Exception;
	
	List<ProductDTO> getAllProductByCategory(int id) throws Exception;
	
	List<CategoryDTO> getAllCategory() throws Exception;
}
