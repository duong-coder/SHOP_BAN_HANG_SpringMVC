package com.duong.dao;

import java.util.List;

import com.duong.entity.DonHang;
import com.duong.entity.NguoiDung;

public interface OrderDAO {
	public void insert(DonHang donHang) throws Exception;

	int getIdDonHang(NguoiDung nd) throws Exception;

	List<DonHang> getOrderByStatus(boolean status) throws Exception ;
}
