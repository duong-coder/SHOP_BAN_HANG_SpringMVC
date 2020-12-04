package com.duong.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.duong.model.CategoryDTO;
import com.duong.model.ColorDTO;
import com.duong.model.ProductDTO;
import com.duong.model.SizeDTO;
import com.duong.service.CategoryService;
import com.duong.service.ColorService;
import com.duong.service.ProductDetailService;
import com.duong.service.ProductService;
import com.duong.service.SizeService;
import com.duong.uitils.ReadWrite;

@Controller
@RequestMapping(value = "/admin")
@PropertySource(value = "classpath:product.properties")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDetailService detailService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private Environment environment;
	@Autowired
	ReadWrite readWrite;

	@RequestMapping(value = "/all-product", method = RequestMethod.GET)
	public String getAllProduct(HttpServletRequest request) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		int sizeAllSP = 0;
		double limit = Double.valueOf(environment.getProperty("product.limit-inPage-admin"));
		//sửa new Integer()
		try {
			productDTOs = productService.getProductLimit(1,(int) limit);
			categoryDTOs = categoryService.getAllCategory();
			sizeAllSP = productService.countAllProduct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("products", productDTOs);
		request.setAttribute("categories", categoryDTOs);
		request.setAttribute("pagination", (int) Math.ceil(sizeAllSP/limit));
//		System.out.println(Math.floor(sizeAllSP/limit));
//		int a = 142;
//		System.out.println(a / 100); 					= 1 
//		System.out.println(Math.ceil(a / 100));			= 1.0
//		System.out.println(a / 100.0);					= 1.42
//		System.out.println(Math.ceil(a / 100.0));		= 2.0
//		System.out.println((int) Math.ceil(a / 100.0));	= 2	
		
		return "admin/product";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest request) {
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		List<ColorDTO> colorDTOs = new ArrayList<ColorDTO>();
		List<SizeDTO> sizeDTOs = new ArrayList<SizeDTO>();
		try {
			categoryDTOs = categoryService.getAllCategory();
			colorDTOs = colorService.getAllColor();
			sizeDTOs = sizeService.getAllSizeSanPham();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productDTO", new ProductDTO());
		request.setAttribute("categoryDTOs", categoryDTOs);
		request.setAttribute("sizeDTOs", sizeDTOs);
		request.setAttribute("colorDTOs", colorDTOs);
		
		return "admin/add-product";
	}

	@RequestMapping(value = "/infor-product/{maSp}", method = RequestMethod.GET)
	public String showDetailProduct(HttpServletRequest request, @PathVariable(value = "maSp") String maSp) {
		ProductDTO productDTO = new ProductDTO();
		try {
			productDTO = productService.getProuctByMaSp(maSp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productDTO", productDTO);

		return "admin/infor-product";
	}

	@RequestMapping(value = "/edit-product/{maSp}", method = RequestMethod.GET)
	public String editProductByMaSP(HttpServletRequest request, 
			@PathVariable(value = "maSp") String maSp) {
		ProductDTO productDTO = new ProductDTO();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		List<ColorDTO> colorDTOs = new ArrayList<ColorDTO>();
		List<SizeDTO> sizeDTOs = new ArrayList<SizeDTO>();
		try {
			productDTO = productService.getProuctByMaSp(maSp);
			categoryDTOs = categoryService.getAllCategory();
			colorDTOs = colorService.getAllColor();
			sizeDTOs = sizeService.getAllSizeSanPham();
			
			System.out.println(productDTO.getTenAnh());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("productDTO", productDTO);
		request.setAttribute("categoryDTOs", categoryDTOs);
		request.setAttribute("sizeDTOs", sizeDTOs);
		request.setAttribute("colorDTOs", colorDTOs);
		

		return "admin/add-product";
	}

	
	@RequestMapping(value = "/delete-product/{maSp}", method = RequestMethod.GET)
	public String deteleProductByMaSP(@PathVariable(value = "maSp") String maSp) {
		try {
			productService.deleteProductByMaSp(maSp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/all-product";
	}
}
