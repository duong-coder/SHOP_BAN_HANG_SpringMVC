package com.duong.controller.admin.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.duong.model.CategoryDTO;
import com.duong.model.ProductDTO;
import com.duong.model.ProductDetailDTO;
import com.duong.model.UserDTO;
import com.duong.service.CategoryService;
import com.duong.service.ColorService;
import com.duong.service.ProductDetailService;
import com.duong.service.ProductService;
import com.duong.service.SizeService;
import com.duong.uitils.ReadWrite;

@RestController
@RequestMapping("/api/admin")
@PropertySource(value = "classpath:product.properties")
public class AdminProductAPI {
	@Autowired
	private ProductDetailService productDetailService;
	@Autowired
	private ProductService productService;
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
	
	@RequestMapping(value = "/amount-product", method = RequestMethod.GET)
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
	@RequestMapping(value="/add-product", method = RequestMethod.POST)
	public void addProduct(@RequestBody ProductDTO productDTO) {
		System.out.println(productDTO.getMaSp());
		try {
			productService.insertProduct(productDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@RequestMapping(value = "/upload-image", method=RequestMethod.POST)
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		try {
			readWrite.saveImageProduct(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/product/{maSp}", method = RequestMethod.GET)
	public ProductDTO getProduct(@PathVariable("maSp") String maSp) {
		System.out.println(maSp);
		ProductDTO productDTO = new ProductDTO();
		try {
			 productDTO = productService.getProuctByMaSp(maSp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productDTO;
	}
	

	@RequestMapping(value = "/edit-product", method = RequestMethod.POST)
	public void editProductByMaSP(@RequestBody ProductDTO productDTO) {
		List<ProductDetailDTO> detailsWillBeDelete = new ArrayList<ProductDetailDTO>();
		try {
			ProductDTO productDTOBefore = productService.getProuctByMaSp(productDTO.getMaSp());
			List<ProductDetailDTO> detailsBefore = productDTOBefore.getDetailDTOs();
			List<ProductDetailDTO> detailsAfter = productDTO.getDetailDTOs();
			for(int i = 0; i < detailsBefore.size(); i++) {
				boolean flagDelete = true;
				for(int j = 0; j < detailsAfter.size(); j++) {
					if(detailsBefore.get(i).getId().equals(detailsAfter.get(j).getId())) {
						flagDelete = false;
						break;
					}
				}
				if(flagDelete) {
					detailsWillBeDelete.add(detailsBefore.get(i));
				}
			}
			for(ProductDetailDTO det:detailsWillBeDelete) {
				System.out.println("Delete CTSP: " +det.getId() + productDTO.getMaSp() + det.getColor().getId() + det.getSize().getId());
				productDetailService.deleteProductDetail(productDTO.getMaSp(), det.getColor().getId(), det.getSize().getId());
			}
			productService.updateProduct(productDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
