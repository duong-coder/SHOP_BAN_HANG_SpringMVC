package com.duong.service;

import java.util.List;

import com.duong.model.ProductDetailDTO;

public interface ProductDetailService {
	
	void insertProductDetail(ProductDetailDTO pDetailDTO) throws Exception;
	
	void insertProductDetail(String maSP, int maMau, int maSize, int soLuong) throws Exception;
	
	void updateProductDetail(ProductDetailDTO proOld, ProductDetailDTO proNew) throws Exception;
	
	void deleteProductDetail(String maSP, int maMau, int maSize) throws Exception;
	
	ProductDetailDTO getProductDetail(String maSP, int maMau, int maSize) throws Exception;
	
	ProductDetailDTO getProductDetail(ProductDetailDTO proDetail) throws Exception;
	
	int getAmountProductDetail(String maSP, int maMau, int maSize) throws Exception;
	
//	ProductDetailDTO getProductDetailByIdSP(ProductDTO productDTO) throws HibernateException;
	
	List<ProductDetailDTO> getAllProductDetail() throws Exception;
}
