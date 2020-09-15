package com.duong.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duong.model.OrderDTO;

@Controller
@RequestMapping("/order")
public class OrderController {

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCart(HttpServletRequest request, HttpSession session) {
		OrderDTO order = (OrderDTO) session.getAttribute("order");
		if (order != null) {
//			request.setAttribute("orderCart", order);
		}
		
		return "home-user/gio-hang";
	}
	
	@RequestMapping(value="/detail/{maHD}", method = RequestMethod.GET)
	public String getDetailOrder(@PathVariable("maHD") int maHD) {
		System.out.println("Ma HD: " + maHD);
		
		return "home-user/chi-tiet-don-hang";
	}
}
