package com.duong.controller.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.duong.model.CategoryDTO;
import com.duong.model.ColorDTO;
import com.duong.model.ProductDTO;
import com.duong.model.ProductDetailDTO;
import com.duong.model.SizeDTO;
import com.duong.service.CategoryService;
import com.duong.service.ProductDetailService;
import com.duong.service.ProductService;
import com.duong.uitils.ProductUitils;

@Controller
@RequestMapping("/products")
public class ProductHomeController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDetailService productDetailService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/all-product", method = RequestMethod.GET)
	public String showAllProduct(HttpServletRequest request) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		try {
			productDTOs = productService.getAllProduct();
			categoryDTOs = categoryService.getAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("productDTOs", productDTOs);
		request.setAttribute("categoryDTOs", categoryDTOs);
		
		return "/home-user/danh-sach-san-pham";
	}
	
	@RequestMapping(value = "/{maSP}", method = RequestMethod.GET)
	public String showProductByMaSP(HttpServletRequest request,
			@PathVariable("maSP") String maSP) {
		ProductDTO productDTO = new ProductDTO();
		Map<String, String> moTas = new HashMap<String, String>();
		List<ProductDetailDTO> detailDTOs = new ArrayList<ProductDetailDTO>();
		Set<ColorDTO> colors = new HashSet<ColorDTO>();
		Set<SizeDTO> sizes = new HashSet<SizeDTO>();
		
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		try {
			productDTO = productService.getProuctByMaSp(maSP);
			moTas = ProductUitils.getInforProduct(productDTO.getMoTa());
			
			detailDTOs = productService.getAllProductDetailByMaSP(maSP);
			sizes = ProductUitils.getSizeProduct(detailDTOs);
			colors = ProductUitils.getColorProduct(detailDTOs);
			
			categoryDTOs = categoryService.getAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productDTO", productDTO);
		request.setAttribute("inforProducts", moTas);
		request.setAttribute("productDetailDTOs", detailDTOs);
		request.setAttribute("colorProductDetailDTOs", colors);
		request.setAttribute("sizeProductDetailDTOs", sizes);
		request.setAttribute("categoryDTOs", categoryDTOs);
		return "/home-user/chi-tiet-san-pham";
	}
	
	@RequestMapping(value = "/category/{id}")
	public String showProductByCategory(HttpServletRequest request,
			@PathVariable("id") int idCategory) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		try {
			productDTOs = categoryService.getAllProductByCategory(idCategory);
			categoryDTOs = categoryService.getAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("productDTOs", productDTOs);
		request.setAttribute("categoryDTOs", categoryDTOs);
		
		return "/home-user/danh-sach-san-pham";
	}
}
