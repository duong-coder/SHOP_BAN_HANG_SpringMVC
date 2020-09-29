package com.duong.controller.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.duong.model.OrderDTO;
import com.duong.model.OrderDetailDTO;
import com.duong.model.UserDTO;
import com.duong.service.OrderDetailService;
import com.duong.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCart(HttpServletRequest request, HttpSession session) {
		OrderDTO order = (OrderDTO) session.getAttribute("order");
		if (order != null) {
//			request.setAttribute("orderCart", order);
		}
		
		return "home-user/gio-hang";
	}
	
	@RequestMapping(value="/save-order", method = RequestMethod.GET)
	public String getDetailOrder(HttpSession session) {
		OrderDTO order = (OrderDTO) session.getAttribute("order");
		if(order != null) {
			UserDTO userDTO = (UserDTO) session.getAttribute("userLogin");
			List<OrderDetailDTO> detailDTOs = order.getOrderDetailDTOs();
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setUser(userDTO);
			orderDTO.setStatus(order.isStatus());
			orderDTO.setDate(order.getDate());
			orderDTO.setOrderDetailDTOs(detailDTOs);
			
			try {
				orderService.insert(orderDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("loi them don hang");
			}
			try {
				orderDTO.setMaHD(orderService.getIdOrder(orderDTO.getUser()));
				orderDetailService.insert(orderDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("loi them don hang");
			}
		}
		
		return "redirect:/";
	}
}
