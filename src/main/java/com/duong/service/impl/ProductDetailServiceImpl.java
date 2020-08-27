package com.duong.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duong.dao.ProductDetailDAO;
import com.duong.entity.ChiTietSanPham;
import com.duong.entity.MauSac;
import com.duong.entity.SanPham;
import com.duong.entity.SizeSanPham;
import com.duong.model.ColorDTO;
import com.duong.model.ProductDTO;
import com.duong.model.ProductDetailDTO;
import com.duong.model.SizeDTO;
import com.duong.service.ProductDetailService;

@Service
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService {

	@Autowired
	private ProductDetailDAO productDetailDAO;

	@Override
	public void insertProductDetail(ProductDetailDTO pDetailDTO) throws Exception {
		ProductDTO proDTO = pDetailDTO.getProductDTO();
		SanPham sp = new SanPham();
		sp.setMaSP(proDTO.getMaSp());
//		sp.setTenSP(proDTO.getTenSp());
//		sp.setMoTa(proDTO.getMoTa());
//		sp.setGia(proDTO.getGia());
//		sp.setAnhMoTa(proDTO.getTenAnh());

		ColorDTO colorDTO = pDetailDTO.getColor();
		MauSac mauSac = new MauSac();
		mauSac.setMaMau(colorDTO.getId());
//		mauSac.setTenMau(colorDTO.getColor());

		SizeDTO sizeDTO = pDetailDTO.getSize();
		SizeSanPham sizeSanPham = new SizeSanPham();
		sizeSanPham.setMaSize(sizeDTO.getId());
//		sizeSanPham.setSize(sizeDTO.getSize());

		ChiTietSanPham ctsp = new ChiTietSanPham();
		ctsp.setSanPham(sp);
		ctsp.setMauSac(mauSac);
		ctsp.setSizeSanPham(sizeSanPham);
		ctsp.setSoLuong(pDetailDTO.getAmount());

		productDetailDAO.insertProductDetail(ctsp);
	}

	@Override
	public void insertProductDetail(String maSP, int maMau, int maSize, int soLuong) throws Exception {
		SanPham sp = new SanPham();
		sp.setMaSP(maSP);
//		sp.setTenSP(proDTO.getTenSp());
//		sp.setMoTa(proDTO.getMoTa());
//		sp.setGia(proDTO.getGia());
//		sp.setAnhMoTa(proDTO.getTenAnh());

		MauSac mauSac = new MauSac();
		mauSac.setMaMau(maMau);
//		mauSac.setTenMau(colorDTO.getColor());

		SizeSanPham sizeSanPham = new SizeSanPham();
		sizeSanPham.setMaSize(maSize);
//		sizeSanPham.setSize(sizeDTO.getSize());

		ChiTietSanPham ctsp = new ChiTietSanPham();
		ctsp.setSanPham(sp);
		ctsp.setMauSac(mauSac);
		ctsp.setSizeSanPham(sizeSanPham);
		ctsp.setSoLuong(soLuong);

		productDetailDAO.insertProductDetail(ctsp);

	}

	@Override
	public void updateProductDetail(ProductDetailDTO proOld, ProductDetailDTO proNew) throws Exception {
		ProductDTO proDTO = proOld.getProductDTO();
		SanPham sp = new SanPham();
		sp.setMaSP(proDTO.getMaSp());

		ColorDTO colorDTO = proOld.getColor();
		MauSac mauSac = new MauSac();
		mauSac.setMaMau(colorDTO.getId());

		SizeDTO sizeDTO = proOld.getSize();
		SizeSanPham sizeSanPham = new SizeSanPham();
		sizeSanPham.setMaSize(sizeDTO.getId());

		ChiTietSanPham ctspOld = new ChiTietSanPham();
		ctspOld.setSanPham(sp);
		ctspOld.setMauSac(mauSac);
		ctspOld.setSizeSanPham(sizeSanPham);
		
		ProductDTO proDTON = proNew.getProductDTO();
		SanPham spN = new SanPham();
		spN.setMaSP(proDTON.getMaSp());

		ColorDTO colorDTON = proNew.getColor();
		MauSac mauSacN = new MauSac();
		mauSacN.setMaMau(colorDTON.getId());

		SizeDTO sizeDTON = proNew.getSize();
		SizeSanPham sizeSanPhamN = new SizeSanPham();
		sizeSanPhamN.setMaSize(sizeDTON.getId());

		ChiTietSanPham ctspNew = new ChiTietSanPham();
		ctspNew.setSanPham(spN);
		ctspNew.setMauSac(mauSacN);
		ctspNew.setSizeSanPham(sizeSanPhamN);
		ctspNew.setSoLuong(proNew.getAmount());
		
		productDetailDAO.updateProductDetail(ctspOld, ctspNew);
	}

	@Override
	public void deleteProductDetail(String maSP, int maMau, int maSize) throws HibernateException {
		productDetailDAO.deleteProductDetail(maSP, maMau, maSize);
	}

	@Override
	public ProductDetailDTO getProductDetail(String maSP, int maMau, int maSize) throws Exception {
		ChiTietSanPham ctsp = productDetailDAO.getProductDetail(maSP, maMau, maSize);

		SanPham sp = ctsp.getSanPham();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setMaSp(sp.getMaSP());
		productDTO.setTenSp(sp.getTenSP());
		productDTO.setMoTa(sp.getMoTa());
		productDTO.setGia(sp.getGia());
		productDTO.setTenAnh(sp.getAnhMoTa());

		MauSac mauSac = ctsp.getMauSac();
		ColorDTO colorDTO = new ColorDTO();
		colorDTO.setId(mauSac.getMaMau());
		colorDTO.setColor(mauSac.getTenMau());

		SizeSanPham sizeSP = ctsp.getSizeSanPham();
		SizeDTO sizeDTO = new SizeDTO();
		sizeDTO.setId(sizeSP.getMaSize());
		sizeDTO.setSize(sizeSP.getSize());

		SanPham sanPham = new SanPham();
		sanPham.setMaSP(productDTO.getMaSp());
		sanPham.setTenSP(productDTO.getTenSp());
		sanPham.setMoTa(productDTO.getMoTa());
		sanPham.setGia(productDTO.getGia());
		sanPham.setAnhMoTa(productDTO.getTenAnh());

		ProductDetailDTO productDetailDTO = new ProductDetailDTO();
//		productDetailDTO.setIdProductDetail(ctsp.getIdChiTiet());
		productDetailDTO.setProductDTO(productDTO);
		productDetailDTO.setColor(colorDTO);
		productDetailDTO.setSize(sizeDTO);
		productDetailDTO.setAmount(ctsp.getSoLuong());

		return productDetailDTO;
	}
	
	@Override
	public ProductDetailDTO getProductDetail(ProductDetailDTO proDetail) throws Exception {
		ChiTietSanPham ctsp = new ChiTietSanPham();
		
		return null;
	}

	@Override
	public int getAmountProductDetail(String maSP, int maMau, int maSize) throws Exception {
		int amount = productDetailDAO.getAmountProductDetail(maSP, maMau, maSize);
		return amount;
	}

	@Override
	public List<ProductDetailDTO> getAllProductDetail() throws Exception {
		/*
		 * ProductDetailDTO productDetailDTO = new ProductDetailDTO(); List<ColorDTO>
		 * colorDTOs = new ArrayList<ColorDTO>(); List<SizeDTO> sizeDTOs = new
		 * ArrayList<SizeDTO>(); List<Integer> amounts = new ArrayList<Integer>();
		 * List<ChiTietSanPham> ctsps = productDetailDAO.getAllProductDetail(); SanPham
		 * sp = ctsps.get(0).getMaSP(); ProductDTO dto = new ProductDTO();
		 * dto.setMaSp(sp.getMaSP()); dto.setTenSp(sp.getTenSP());
		 * dto.setMoTa(sp.getMoTa()); dto.setGia(sp.getGia());
		 * dto.setTenAnh(sp.getAnhMoTa());
		 * 
		 * ctsps.forEach((ctsp) ->{ ColorDTO colorDTO = new ColorDTO();
		 * colorDTO.setId(ctsp.getMaMau().getMaMau());
		 * colorDTO.setColor(ctsp.getMaMau().getTenMau()); colorDTOs.add(colorDTO);
		 * 
		 * SizeDTO sizeDTO = new SizeDTO(); sizeDTO.setId(ctsp.getMaSize().getMaSize());
		 * sizeDTO.setSize(ctsp.getMaSize().getSize()); sizeDTOs.add(sizeDTO);
		 * 
		 * amounts.add(ctsp.getSoLuong()); }); productDetailDTO.setProductDTO(dto);
		 * productDetailDTO.setColors(colorDTOs); productDetailDTO.setSizes(sizeDTOs);
		 * productDetailDTO.setAmount(amounts);
		 */
		return null;
	}

}
