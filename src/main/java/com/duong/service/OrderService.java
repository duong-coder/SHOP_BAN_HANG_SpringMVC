package com.duong.service;

import com.duong.model.OrderDTO;
import com.duong.model.UserDTO;

public interface OrderService {
	public void insert(OrderDTO orderDTO) throws Exception;

	int getIdOrder(UserDTO userDTO) throws Exception ;

	int getAmountOrderByStatus(boolean status) throws Exception;
} 
