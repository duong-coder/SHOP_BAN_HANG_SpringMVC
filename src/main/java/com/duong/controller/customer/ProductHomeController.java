package com.duong.controller.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duong.model.ProductDTO;
import com.duong.service.ProductService;
import com.duong.uitils.ProductUitils;

@Controller
@RequestMapping("/products")
public class ProductHomeController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/all-product", method = RequestMethod.GET)
	public String showAllProduct(HttpServletRequest request) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		try {
			productDTOs = productService.getAllProduct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("productDTOs", productDTOs);
		
		return "/home-user/danh-sach-san-pham";
	}
	
	@RequestMapping(value = "/{maSP}", method = RequestMethod.GET)
	public String showProductByMaSP(HttpServletRequest request,
			@PathVariable("maSP") String maSP) {
		ProductDTO productDTO = new ProductDTO();
		Map<String, String> moTas = new HashMap<String, String>();
		try {
			productDTO = productService.getProuctByMaSp(maSP);
			moTas = ProductUitils.getInforProduct(productDTO.getMoTa());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productDTO", productDTO);
		request.setAttribute("inforProducts", moTas);
		
		return "/home-user/chi-tiet-san-pham";
	}
}
