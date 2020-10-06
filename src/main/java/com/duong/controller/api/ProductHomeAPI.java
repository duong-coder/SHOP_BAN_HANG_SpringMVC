package com.duong.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duong.model.CategoryDTO;
import com.duong.model.ProductDTO;
import com.duong.model.UserDTO;
import com.duong.service.ProductDetailService;
import com.duong.service.ProductService;

@RestController
@RequestMapping("/api")
@PropertySource(value = "classpath:product.properties")
public class ProductHomeAPI {
	@Autowired
	private ProductDetailService productDetailService;
	@Autowired
	private ProductService productService;
	@Autowired
	private Environment environment;
	
	@RequestMapping( value ="/amount-product-detail", method = RequestMethod.GET)
	public String getAmountProductDetail(@RequestParam("maSP") String maSP,
			@RequestParam("maMau") int maMau,
			@RequestParam("maSize") int maSize) {
		int kq = -1;
		try {
			kq = productDetailService.getAmountProductDetail(maSP, maMau, maSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("so luong" + kq);
		return kq + "";
	}
	
	@RequestMapping(value = "/product-limit/{index}", method = RequestMethod.GET)
	public List<ProductDTO> getProductsLimit(@PathVariable("index") int indexLimit) {
		int limit = Integer.parseInt(environment.getProperty("product.limit-inPage"));
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		try {
			productDTOs = productService.getProductLimit(indexLimit, limit);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productDTOs;
	}
	
}
