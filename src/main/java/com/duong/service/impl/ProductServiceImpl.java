package com.duong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duong.dao.ProductDAO;
import com.duong.entity.Sanpham;
import com.duong.model.ProductDTO;
import com.duong.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void insertProduct(ProductDTO proDTO) throws Exception {
		Sanpham sp = new Sanpham();
		sp.setMaSP(proDTO.getMaSp());
		sp.setTenSP(proDTO.getTenSp());
		sp.setMoTa(proDTO.getMoTa());
		sp.setGia(proDTO.getGia());
		sp.setSoLuong(proDTO.getSoLuong());
		sp.setAnhMoTa(proDTO.getTenAnh());
		
		productDAO.insertProduct(sp);
	}

	@Override
	public void updateProduct(ProductDTO proDTO) throws Exception {
		ProductDTO dto = getProuctByMaSp(proDTO.getMaSp());
		if(dto!= null) {
			Sanpham sp = new Sanpham();
			sp.setMaSP(proDTO.getMaSp());
			sp.setTenSP(proDTO.getTenSp());
			sp.setMoTa(proDTO.getMoTa());
			sp.setGia(proDTO.getGia());
			sp.setSoLuong(proDTO.getSoLuong());
			sp.setAnhMoTa(proDTO.getTenAnh());
			
			productDAO.updateProduct(sp);
		}
	}

	@Override
	public void deleteProductByMaSp(String maSp) throws Exception {
		ProductDTO dto = getProuctByMaSp(maSp);
		if(dto!= null) {
			productDAO.deleteProductByMaSp(maSp);
		}
		
	}

	@Override
	public ProductDTO getProuctByMaSp(String maSp) throws Exception {
		Sanpham sp = productDAO.getProuctByMaSp(maSp);
		ProductDTO dto = new ProductDTO();
		dto.setMaSp(sp.getMaSP());
		dto.setTenSp(sp.getTenSP());
		dto.setMoTa(sp.getMoTa());
		dto.setGia(sp.getGia());
		dto.setSoLuong(sp.getSoLuong());
		dto.setTenAnh(sp.getAnhMoTa());
		
		return dto;
	}

	@Override
	public List<ProductDTO> getAllProduct() throws Exception {
		List<Sanpham> sanphams = productDAO.getAllProduct();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanphams.forEach((sp) ->{
			ProductDTO dto = new ProductDTO();
			dto.setMaSp(sp.getMaSP());
			dto.setTenSp(sp.getTenSP());
			dto.setMoTa(sp.getMoTa());
			dto.setGia(sp.getGia());
			dto.setSoLuong(sp.getSoLuong());
			dto.setTenAnh(sp.getAnhMoTa());
			
			productDTOs.add(dto);
		});
		return productDTOs;
	}
	
	@Override
	public List<ProductDTO> getTopProduct(int soLuong) throws Exception {
		List<Sanpham> sanphams = productDAO.getTopProduct(soLuong);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanphams.forEach((sp) ->{
			ProductDTO dto = new ProductDTO();
			dto.setMaSp(sp.getMaSP());
			dto.setTenSp(sp.getTenSP());
			dto.setMoTa(sp.getMoTa());
			dto.setGia(sp.getGia());
			dto.setSoLuong(sp.getSoLuong());
			dto.setTenAnh(sp.getAnhMoTa());
			
			productDTOs.add(dto);
		});
		return productDTOs;
	}
}
