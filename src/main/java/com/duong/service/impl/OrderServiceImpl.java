package com.duong.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duong.dao.OrderDAO;
import com.duong.entity.DonHang;
import com.duong.entity.NguoiDung;
import com.duong.model.OrderDTO;
import com.duong.model.UserDTO;
import com.duong.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public void insert(OrderDTO orderDTO) throws Exception {
		DonHang donHang = new DonHang();
		NguoiDung nd = new NguoiDung();
		UserDTO userDTO = orderDTO.getUser();
		nd.setId(userDTO.getID());
		nd.setMaNguoiDung(userDTO.getUsername());
		nd.setMatKhau(userDTO.getPass());
		nd.setHoTen(userDTO.getName());
		nd.setGioiTinh(userDTO.isGender());
		nd.setEmail(userDTO.getEmail());
		nd.setSoDT(userDTO.getPhone());
		nd.setDiaChi(userDTO.getAddress());
		nd.setRole(userDTO.getRole());
		
		
		donHang.setNguoiDung(nd);
		donHang.setDiaChi(userDTO.getAddress());
		donHang.setNgayMua(new Date());
		donHang.setTinhTrang(false);
		
		orderDAO.insert(donHang);
	}
	
	@Override
	public int getIdOrder(UserDTO userDTO) {
		NguoiDung nd = new NguoiDung();
		nd.setId(userDTO.getID());
		
		return orderDAO.getIdDonHang(nd);
	}
}
