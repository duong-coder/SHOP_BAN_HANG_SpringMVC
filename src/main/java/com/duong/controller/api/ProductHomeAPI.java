package com.duong.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duong.service.ProductDetailService;

@Controller
@RequestMapping("/api")
public class ProductHomeAPI {
	@Autowired
	private ProductDetailService productDetailService;
	
	@RequestMapping( value ="/amount-product-detail", method = RequestMethod.GET)
	@ResponseBody
	public String getAmountProductDetail(@RequestParam("maSP") String maSP,
			@RequestParam("maMau") int maMau,
			@RequestParam("maSize") int maSize) {
		int kq = productDetailService.getAmountProductDetail(maSP, maMau, maSize);
		System.out.println("so luong" + kq);
		return kq + "";
	}
}
