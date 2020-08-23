package com.duong.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duong.model.UserDTO;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String getHomePage(HttpServletRequest request,
			@ModelAttribute(value = "userDTO") UserDTO userDTO) {
		request.setAttribute("userDTO", userDTO);
		System.out.println(userDTO.getUsername());
		return "/home-user/trang-chu";
	}
}
