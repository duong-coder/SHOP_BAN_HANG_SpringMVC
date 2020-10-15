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
import com.duong.model.ProductDTO;
import com.duong.service.CategoryService;
import com.duong.service.ProductService;
import com.duong.uitils.ReadWrite;

@Controller
@RequestMapping(value = "/admin")
@PropertySource(value = "classpath:product.properties")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private Environment environment;
	@Autowired
	ReadWrite readWrite;

	@RequestMapping(value = "/all-product", method = RequestMethod.GET)
	public String getAllProduct(HttpServletRequest request) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		int sizeAllSP = 0;
		double limit = new Integer(environment.getProperty("product.limit-inPage-admin"));
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
		try {
			categoryDTOs = categoryService.getAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productDTO", new ProductDTO());
		request.setAttribute("categoryDTOs", categoryDTOs);
		
		return "product/form-product";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, @ModelAttribute(value = "productDTO") ProductDTO productDTO,
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam("categoryID") int categoryId) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryId);
		productDTO.setCategory(categoryDTO);
		try {
			readWrite.saveImageProduct(file);
			productDTO.setTenAnh(file.getOriginalFilename());
			productService.insertProduct(productDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "product/form-product";
		}

		return "redirect:/admin/all-product";
	}

	@RequestMapping(value = "/infor-product/{maSp}", method = RequestMethod.GET)
	public String showDetailProduct(HttpServletRequest request, @PathVariable(value = "maSp") String maSp) {
		ProductDTO productDTO = null;
		try {
			productDTO = productService.getProuctByMaSp(maSp);
			request.setAttribute("productDTO", productDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "product/view-product";
	}

	@RequestMapping(value = "/edit-product/{maSp}", method = RequestMethod.GET)
	public String editProductByMaSP(HttpServletRequest request, 
			@PathVariable(value = "maSp") String maSp) {
		ProductDTO productDTO = null;
		List<CategoryDTO> categoryDTOs = new ArrayList<CategoryDTO>();
		try {
			productDTO = productService.getProuctByMaSp(maSp);
			categoryDTOs = categoryService.getAllCategory();
			
			request.setAttribute("productDTO", productDTO);
			request.setAttribute("categoryDTOs", categoryDTOs);
			System.out.println(productDTO.getTenAnh());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "product/form-edit-product";
	}

	@RequestMapping(value = "/edit-product", method = RequestMethod.POST)
	public String editProductByMaSP(HttpServletRequest request, @ModelAttribute(value = "productDTO") ProductDTO dto,
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam("categoryID") int categoryId) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryId);
		dto.setCategory(categoryDTO);
		try {
			readWrite.saveImageProduct(file);
			dto.setTenAnh(file.getOriginalFilename());
			productService.updateProduct(dto);
		} catch (Exception e) {
			e.printStackTrace();

			return "redirect:/admin/edit-product/" + dto.getMaSp();
		}

		return "redirect:/admin/infor-product/" + dto.getMaSp();
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
