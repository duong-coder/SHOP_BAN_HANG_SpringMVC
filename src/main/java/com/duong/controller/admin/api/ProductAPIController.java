package com.duong.controller.admin.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.duong.model.ProductDTO;
import com.duong.service.CategoryService;
import com.duong.service.ProductService;

@RestController
@RequestMapping("/api/admin")
@PropertySource(value = "classpath:product.properties")
public class ProductAPIController {
//	@Autowired
//	private ProductDetailService productDetailService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = "/product-limit/{index}", method = RequestMethod.GET)
	public List<ProductDTO> getProductsLimit(@PathVariable("index") int indexLimit) {
		int limit = Integer.parseInt(environment.getProperty("product.limit-inPage-admin"));
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		try {
			productDTOs = productService.getProductLimit(indexLimit, limit);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productDTOs;
	}
	
	@RequestMapping(value = "/product-limit-category/{categoryID}/{index}", method = RequestMethod.GET)
	public List<ProductDTO> getProductsLimitAndCategory(@PathVariable("categoryID") int categoryID, 
			@PathVariable("index") int indexLimit) {
		int limit = Integer.parseInt(environment.getProperty("product.limit-inPage-admin"));
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		try {
			productDTOs = productService.getProductLimitAndCategory(categoryID, indexLimit, limit);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productDTOs;
	}
	
	@RequestMapping(value = "/product-limit-category/{categoryID}")
	public int getAmountProductByCategory(@PathVariable("categoryID") int idCategory) {
		int amountProductCategory = 0;
		try {
			amountProductCategory = categoryService.getAmountProductByCategory(idCategory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return amountProductCategory;
	}
	
	@RequestMapping(value = "/amount-product")
	public int getAmountProduct() {
		int amountProduct = 0;
		try {
			amountProduct = productService.countAllProduct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return amountProduct;
	}
}
