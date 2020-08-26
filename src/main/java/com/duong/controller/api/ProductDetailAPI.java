package com.duong.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duong.model.ProductDTO;
import com.duong.service.ProductService;

@Controller
@RequestMapping("/api")
public class ProductDetailAPI {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/name-product", method = RequestMethod.GET)
	@ResponseBody
	public String getNameProduct(@RequestParam("maSP") String maSP) {
		ProductDTO productDTO = null;
		try {
			productDTO = productService.getProuctByMaSp(maSP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(productDTO != null) {
			return productDTO.getTenSp();
		}
		return "";
	}
}
