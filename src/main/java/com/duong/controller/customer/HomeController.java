package com.duong.controller.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duong.entity.ChiTietSanPham;
import com.duong.entity.SanPham;
import com.duong.model.ProductDTO;
import com.duong.model.UserDTO;
import com.duong.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value = "/")
	public String getHomePage(HttpServletRequest request,
			@ModelAttribute(value = "userDTO") UserDTO userDTO) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		try {
			productDTOs = productService.getTopProduct(8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("userDTO", userDTO);
		request.setAttribute("productDTOs", productDTOs);
		
		System.out.println(userDTO.getUsername());
		/*
		 * ////// Session session = sessionFactory.openSession(); SanPham pham =
		 * (SanPham) session.get(SanPham.class, "SP01"); List<ChiTietSanPham>
		 * tietSanPhams = pham.getChiTietSanPhams(); for(ChiTietSanPham
		 * ctsp:tietSanPhams) { System.out.println(ctsp.getIdChiTiet() + "///" +
		 * ctsp.getMauSac().getTenMau() + "///" + ctsp.getSanPham().getTenSP() + "///" +
		 * + ctsp.getSoLuong()); }
		 */
		
		////
		return "/home-user/trang-chu";
	}
}
