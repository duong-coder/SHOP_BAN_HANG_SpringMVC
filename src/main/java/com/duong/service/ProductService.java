package com.duong.service;

import java.util.List;

import com.duong.model.ProductDTO;

public interface ProductService {
	void insertProduct(ProductDTO proDTO) throws Exception;
	
	void updateProduct(ProductDTO proDTO) throws Exception;
	
	void deleteProductByMaSp(String maSp ) throws Exception;
	
	ProductDTO getProuctByMaSp(String maSp ) throws Exception;
	
	List<ProductDTO> getAllProduct() throws Exception;
}
