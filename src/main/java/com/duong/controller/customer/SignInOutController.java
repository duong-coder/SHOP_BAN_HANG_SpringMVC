package com.duong.controller.customer;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.duong.model.UserDTO;
import com.duong.service.UserService;

@Controller
public class SignInOutController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String getSignIn(HttpServletRequest request) {
		request.setAttribute("userDTO", new UserDTO());
		return "/home-user/dang-nhap";
	}
	
	@RequestMapping(value = "/sign-in", method = RequestMethod.POST)
	public String postSignIn(HttpServletRequest request,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			RedirectAttributes ra,
			HttpSession httpSession) {
		System.out.println(">>> username: " + username);
		System.out.println(">>> password: " + password);
		
		UserDTO dto = null;
		try {
			dto = userService.getSignInByMaNguoiDung(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dto == null) {
			return "redirect:/sign-in";
		}
		if("ROLE_ADMIN".equals(dto.getRole())) {
			return "redirect:/admin/all-user";
		}
//		ra.addFlashAttribute("userDTO", dto);
		httpSession.setAttribute("userLogin", dto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/sign-out", method = RequestMethod.GET)
	public String getSignOut(HttpServletRequest request,
			HttpSession httpSession) {
		httpSession.removeAttribute("userLogin");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String getSignUp(HttpServletRequest request) {
		request.setAttribute("userRegister", new UserDTO());
		
		return "/home-user/dang-ky";
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String postSignUp(HttpServletRequest request,
			@ModelAttribute(value = "userRegister") UserDTO dto) {
		try {
			dto.setRole("ROLE_KHACH");
			userService.insertUser(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "redirect:/sign-up";
		}
		
		return "redirect:/sign-in";
	}
}
