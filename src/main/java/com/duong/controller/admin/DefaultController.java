package com.duong.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duong.service.OrderService;
import com.duong.service.ProductService;
import com.duong.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class DefaultController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String defaultIndex(Model model) {
		int amountUser = -1;
		int amountProduct = -1;
		int amountOrderShipping = -1;
		try {
			amountUser = userService.getAllUser().size();
			amountProduct = productService.countAllProduct();
			amountOrderShipping = orderService.getAmountOrderByStatus(false);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("amountUser", amountUser);
		model.addAttribute("amountProduct", amountProduct);
		model.addAttribute("amountOrderShipping", amountOrderShipping);
		
		return "/admin/home-admin";
	}
}
