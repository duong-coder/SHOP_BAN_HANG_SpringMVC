package com.duong.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.duong.model.ProductDTO;
import com.duong.service.ProductService;
import com.duong.uitils.ReadWrite;

@Controller
@RequestMapping(value = "/admin")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	ReadWrite readWrite;

	@RequestMapping(value = "/all-product", method = RequestMethod.GET)
	public String getAllProduct(HttpServletRequest request) {
		List<ProductDTO> productDTOs = null;
		try {
			productDTOs = productService.getAllProduct();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productDTOs", productDTOs);
		return "product/view-all-product";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public String addProduct(HttpServletRequest request) {
		request.setAttribute("productDTO", new ProductDTO());

		return "product/form-product";
	}

	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request, @ModelAttribute(value = "productDTO") ProductDTO productDTO,
			@RequestParam(value = "file") MultipartFile file) {
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

	@RequestMapping(value = "/product-detail/{maSp}", method = RequestMethod.GET)
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
		try {
			productDTO = productService.getProuctByMaSp(maSp);
			request.setAttribute("productDTO", productDTO);
			System.out.println(productDTO.getTenAnh());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "product/form-edit-product";
	}

	@RequestMapping(value = "/edit-product", method = RequestMethod.POST)
	public String editProductByMaSP(HttpServletRequest request, @ModelAttribute(value = "productDTO") ProductDTO dto,
			@RequestParam(value = "file") MultipartFile file) {
//		System.out.println(dto.getTenAnh());
		try {
			readWrite.saveImageProduct(file);
			dto.setTenAnh(file.getOriginalFilename());
			productService.updateProduct(dto);
		} catch (Exception e) {
			e.printStackTrace();

			return "redirect:/admin/edit-product/" + dto.getMaSp();
		}

		return "redirect:/admin/product-detail/" + dto.getMaSp();
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
