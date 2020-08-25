package com.duong.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.duong.model.ProductDTO;
import com.duong.model.ProductDetailDTO;

public interface ProductDetailService {
	
	void insertProductDetail(ProductDetailDTO pDetailDTO) throws HibernateException;
	
	void updateProductDetail(ProductDetailDTO pDetailDTO) throws HibernateException;
	
	void deleteProductDetail(int id) throws HibernateException;
	
	ProductDetailDTO getProductDetailByIdCT(int id) throws HibernateException;
	
	int getAmountProductDetail(String maSP, int maMau, int maSize) throws HibernateException;
	
//	ProductDetailDTO getProductDetailByIdSP(ProductDTO productDTO) throws HibernateException;
	
	List<ProductDetailDTO> getAllProductDetail() throws HibernateException;
}
