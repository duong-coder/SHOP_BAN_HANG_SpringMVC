package com.duong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duong.dao.ProductDAO;
import com.duong.entity.ChiTietSanPham;
import com.duong.entity.MauSac;
import com.duong.entity.SanPham;
import com.duong.entity.SizeSanPham;
import com.duong.model.ColorDTO;
import com.duong.model.ProductDTO;
import com.duong.model.ProductDetailDTO;
import com.duong.model.SizeDTO;
import com.duong.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void insertProduct(ProductDTO proDTO) throws Exception {
		SanPham sp = new SanPham();
		sp.setMaSP(proDTO.getMaSp());
		sp.setTenSP(proDTO.getTenSp());
		sp.setMoTa(proDTO.getMoTa());
		sp.setGia(proDTO.getGia());
		sp.setAnhMoTa(proDTO.getTenAnh());
		
		productDAO.insertProduct(sp);
	}

	@Override
	public void updateProduct(ProductDTO proDTO) throws Exception {
		ProductDTO dto = getProuctByMaSp(proDTO.getMaSp());
		if(dto!= null) {
			SanPham sp = new SanPham();
			sp.setMaSP(proDTO.getMaSp());
			sp.setTenSP(proDTO.getTenSp());
			sp.setMoTa(proDTO.getMoTa());
			sp.setGia(proDTO.getGia());
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
		SanPham sp = productDAO.getProuctByMaSp(maSp);
		ProductDTO dto = new ProductDTO();
		dto.setMaSp(sp.getMaSP());
		dto.setTenSp(sp.getTenSP());
		dto.setMoTa(sp.getMoTa());
		dto.setGia(sp.getGia());
		dto.setTenAnh(sp.getAnhMoTa());
		
		return dto;
	}

	@Override
	public List<ProductDTO> getAllProduct() throws Exception {
		List<SanPham> sanphams = productDAO.getAllProduct();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanphams.forEach((sp) ->{
			ProductDTO dto = new ProductDTO();
			dto.setMaSp(sp.getMaSP());
			dto.setTenSp(sp.getTenSP());
			dto.setMoTa(sp.getMoTa());
			dto.setGia(sp.getGia());
			dto.setTenAnh(sp.getAnhMoTa());
			
			productDTOs.add(dto);
		});
		return productDTOs;
	}
	
	@Override
	public List<ProductDTO> getTopProduct(int soLuong) throws Exception {
		List<SanPham> sanphams = productDAO.getTopProduct(soLuong);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanphams.forEach((sp) ->{
			ProductDTO dto = new ProductDTO();
			dto.setMaSp(sp.getMaSP());
			dto.setTenSp(sp.getTenSP());
			dto.setMoTa(sp.getMoTa());
			dto.setGia(sp.getGia());
			dto.setTenAnh(sp.getAnhMoTa());
			
			productDTOs.add(dto);
		});
		return productDTOs;
	}
	
	@Override
	public List<ProductDetailDTO> getAllProductDetailByMaSP(String maSP) throws Exception {
		SanPham sp = productDAO.getProuctByMaSp(maSP);
		List<ChiTietSanPham> ctsps = productDAO.getAllProductDetailByMaSP(maSP);
		if(sp != null) {
			List<ProductDetailDTO> proDetails = new ArrayList<ProductDetailDTO>();
			for(ChiTietSanPham ctsp:ctsps) {
				SanPham sanPham = ctsp.getSanPham();
				ProductDTO dto = new ProductDTO();
				dto.setMaSp(sanPham.getMaSP());
				dto.setTenSp(sanPham.getTenSP());
				dto.setMoTa(sanPham.getMoTa());
				dto.setGia(sanPham.getGia());
				dto.setTenAnh(sanPham.getAnhMoTa());
				
				MauSac mauSac = ctsp.getMauSac();
				ColorDTO colorDTO = new ColorDTO();
				colorDTO.setId(mauSac.getMaMau());
				colorDTO.setColor(mauSac.getTenMau());
				
				SizeSanPham sizeSP = ctsp.getSizeSanPham();
				SizeDTO sizeDTO = new SizeDTO();
				sizeDTO.setId(sizeSP.getMaSize());
				sizeDTO.setSize(sizeSP.getSize());
				
				ProductDetailDTO productDetailDTO = new ProductDetailDTO();
//				productDetailDTO.setIdProductDetail(ctsp.getIdChiTiet());
				productDetailDTO.setProductDTO(dto);
				productDetailDTO.setColor(colorDTO);
				productDetailDTO.setSize(sizeDTO);
				productDetailDTO.setAmount(ctsp.getSoLuong());
				
				proDetails.add(productDetailDTO);
			};
			
			return proDetails;
		}
		return null;
	}
}
