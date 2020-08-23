package com.duong.controller.admin;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duong.model.UserDTO;
import com.duong.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String getInsertUser(HttpServletRequest request) {
		UserDTO userDTO = new UserDTO();
		request.setAttribute("userDTO", userDTO);
		
		return "/user/form-user";
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String getInsertUser(HttpServletRequest request, 
			@ModelAttribute(value = "userDTO") UserDTO dto) {
		System.out.println(dto.getName());
		try {
			userService.insertUser(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:/all-user" ;
	}
	
	@RequestMapping(value = "/all-user", method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request) {
		List<UserDTO> userDTOs;
		try {
			userDTOs = userService.getAllUser();
		} catch (SQLException e) {
			e.printStackTrace();
			return "/user/view-all-user";
		}
		request.setAttribute("userDTOs", userDTOs);
		
		return "/user/view-all-user";
	}
	@RequestMapping(value = "/user-detail/{id}", method = RequestMethod.GET)
	public String getUserDetailById(HttpServletRequest request,
			@PathVariable(value = "id") int id) {
		UserDTO dto;
		try {
			dto = userService.getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return "redirect:/admin/all-user";
		}
		request.setAttribute("userDTO", dto);
		
		return "/user/view-user";
	}
	
	@RequestMapping(value = "/delete-user/{id}", method = RequestMethod.GET)
	public String deleteUserById(HttpServletRequest request,
			@PathVariable(value = "id") int id) {
		System.out.println("xoa khach hang");
		try {
			userService.deleteUserById(id);
			System.out.println("xoa thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/all-user";
		}
		return "redirect:/admin/all-user";
	}
	
	@RequestMapping(value = "/edit-user/{id}", method = RequestMethod.GET)
	public String editUserById(HttpServletRequest request,
			@PathVariable(value = "id") int id) {
		UserDTO dto;
		try {
			dto = userService.getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return "redirect:/admin/all-user";
		}
		request.setAttribute("userDTO", dto);
		return "/user/form-edit-user";
	}
	@RequestMapping(value = "/edit-user", method = RequestMethod.POST)
	public String editUserById(HttpServletRequest request,
			@ModelAttribute(value = "userDTO") UserDTO userDTO) {
		try {
			userService.updateUser(userDTO);
		} catch (SQLException e) {
			e.printStackTrace();
			return "redirect:/admin/edit-user";
		}
		return "redirect:/admin/all-user";
	}
}
