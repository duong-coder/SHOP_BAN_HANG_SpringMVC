package com.duong.service;

import java.util.List;

import com.duong.model.ProductDetailDTO;

public interface ProductDetailService {
	
	void insertProductDetail(ProductDetailDTO pDetailDTO) throws Exception;
	
	void insertProductDetail(String maSP, int maMau, int maSize, int soLuong) throws Exception;
	
	void updateProductDetail(ProductDetailDTO pDetailDTO) throws Exception;
	
	void deleteProductDetail(int id) throws Exception;
	
	ProductDetailDTO getProductDetailByIdCT(int id) throws Exception;
	
	int getAmountProductDetail(String maSP, int maMau, int maSize) throws Exception;
	
//	ProductDetailDTO getProductDetailByIdSP(ProductDTO productDTO) throws HibernateException;
	
	List<ProductDetailDTO> getAllProductDetail() throws Exception;
}
