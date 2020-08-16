package com.duong.dao;

import java.util.List;

import com.duong.entity.Sanpham;

public interface ProductDAO {
	void insertProduct(Sanpham sp) throws Exception;
	
	void updateProduct(Sanpham sp) throws Exception;
	
	void deleteProductByMaSp(String maSp ) throws Exception;
	
	Sanpham getProuctByMaSp(String maSp ) throws Exception;
	
	List<Sanpham> getAllProduct() throws Exception;
}
