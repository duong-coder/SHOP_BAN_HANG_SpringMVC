package com.duong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duong.dao.OrderDetailDAO;
import com.duong.entity.ChiTietDonHang;
import com.duong.entity.ChiTietSanPham;
import com.duong.entity.DonHang;
import com.duong.model.OrderDTO;
import com.duong.model.OrderDetailDTO;
import com.duong.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	public void insert(OrderDTO orderDTO) throws Exception {
		
		DonHang donhang = new DonHang();
		donhang.setMaHD(orderDTO.getMaHD());
		List<OrderDetailDTO> detailDTOs = orderDTO.getOrderDetailDTOs();
		for(OrderDetailDTO detailDTO:detailDTOs) {
			ChiTietSanPham ctsp = new ChiTietSanPham();
			ctsp.setIdChiTiet(detailDTO.getProductDetail().getId());
			ChiTietDonHang ctdh = new ChiTietDonHang();
			ctdh.setcTSP(detailDTO.getProductDetail().getId());
			ctdh.setDonhang(donhang);
			ctdh.setGiaTien(detailDTO.getPrice());
			ctdh.setSoLuong(detailDTO.getAmount());
			
			orderDetailDAO.insert(ctdh);
		}
		
	}
}
