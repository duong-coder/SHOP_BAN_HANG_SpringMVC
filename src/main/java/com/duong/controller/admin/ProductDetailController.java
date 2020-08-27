package com.duong.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.duong.model.ColorDTO;
import com.duong.model.ProductDTO;
import com.duong.model.ProductDetailDTO;
import com.duong.model.SizeDTO;
import com.duong.service.ColorService;
import com.duong.service.ProductDetailService;
import com.duong.service.ProductService;
import com.duong.service.SizeService;

@Controller
@RequestMapping("/admin")
public class ProductDetailController {
	@Autowired
	private ProductDetailService detailService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;
	
	@RequestMapping(value = "/all-product-detail/{maSP}", method =  RequestMethod.GET)
	public String getAllProductDetail(HttpServletRequest request,
			@PathVariable("maSP") String maSP) {
		List<ProductDetailDTO> proDetails = new ArrayList<ProductDetailDTO>();
		try {
			proDetails = productService.getAllProductDetailByMaSP(maSP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("productDetails", proDetails);
		
		return "product/view-all-product-detail";
	}
	
	@RequestMapping(value = "/add-product-detail", method =  RequestMethod.GET)
	public String getAddProductDetail(HttpServletRequest request) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		List<ColorDTO> colorDTOs = new ArrayList<ColorDTO>();
		List<SizeDTO> sizeDTOs = new ArrayList<SizeDTO>();
		try {
			productDTOs = productService.getAllProduct();
			colorDTOs = colorService.getAllColor();
			sizeDTOs = sizeService.getAllSizeSanPham();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productDetailDTO", new ProductDetailDTO());
		request.setAttribute("productDTOs", productDTOs);
		request.setAttribute("sizeDTOs", sizeDTOs);
		request.setAttribute("colorDTOs", colorDTOs);
		
		return "product/form-product-detail";
	}
	@RequestMapping(value = "/add-product-detail", method =  RequestMethod.POST)
	public String postAddProductDetail(HttpServletRequest request,
			@RequestParam("productID") String maSP,
			@RequestParam("colorID") int maMau,
			@RequestParam("sizeID") int maSize,
			@RequestParam("amount") int soLuong) {
		System.out.println(maMau +"//" + maSize);
			try {
				detailService.insertProductDetail(maSP, maMau, maSize, soLuong);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return "redirect:/admin/all-product-detail/" + maSP;
	}
}
