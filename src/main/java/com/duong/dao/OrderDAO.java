package com.duong.dao;

import com.duong.entity.DonHang;
import com.duong.entity.NguoiDung;

public interface OrderDAO {
	public void insert(DonHang donHang) throws Exception;

	int getIdDonHang(NguoiDung nd);
}
