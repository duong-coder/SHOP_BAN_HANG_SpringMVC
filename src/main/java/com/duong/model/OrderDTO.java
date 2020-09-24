package com.duong.model;

import java.util.Date;
import java.util.List;

public class OrderDTO {
	private int maHD;
	private UserDTO user;
	private Date date;
	private boolean status;
	private List<OrderDetailDTO> orderDetailDTOs ;
	
	public double getTotalPrice() {
		double totalPrice = 0d;
		if(this.orderDetailDTOs != null) {
			for(OrderDetailDTO orderDetailDTO:orderDetailDTOs) {
				totalPrice += orderDetailDTO.getPrice();
			}
		}
		
		return totalPrice;
	}
	
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<OrderDetailDTO> getOrderDetailDTOs() {
		return orderDetailDTOs;
	}
	public void setOrderDetailDTOs(List<OrderDetailDTO> orderDetailDTOs) {
		this.orderDetailDTOs = orderDetailDTOs;
	}
	
	
}
