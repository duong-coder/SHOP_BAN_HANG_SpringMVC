package com.duong.dao;

import java.util.List;

import com.duong.entity.ChiTietSanPham;
import com.duong.entity.SanPham;

public interface ProductDAO {
	void insertProduct(SanPham sp) throws Exception;
	
	void updateProduct(SanPham sp) throws Exception;
	
	void deleteProductByMaSp(String maSp ) throws Exception;
	
	SanPham getProuctByMaSp(String maSp ) throws Exception;
	
	List<SanPham> getAllProduct() throws Exception;
	
	List<SanPham> getTopProduct(int soLuong) throws Exception;
	
	List<ChiTietSanPham> getAllProductDetailByMaSP(String maSP) throws Exception;
}
