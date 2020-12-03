package com.duong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duong.dao.ProductDAO;
import com.duong.dao.ProductDetailDAO;
import com.duong.entity.ChiTietSanPham;
import com.duong.entity.DanhMuc;
import com.duong.entity.MauSac;
import com.duong.entity.SanPham;
import com.duong.entity.SizeSanPham;
import com.duong.model.CategoryDTO;
import com.duong.model.ColorDTO;
import com.duong.model.ProductDTO;
import com.duong.model.ProductDetailDTO;
import com.duong.model.SizeDTO;
import com.duong.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	ProductDetailDAO detailDAO;

	@Override
	public void insertProduct(ProductDTO proDTO) throws Exception {
		SanPham sp = mapDTOToEntity(proDTO);

		productDAO.insertProduct(sp);
	}

	@Override
	public void updateProduct(ProductDTO proDTO) throws Exception {
		ProductDTO dto = getProuctByMaSp(proDTO.getMaSp());
		if (dto != null) {
			SanPham sp = mapDTOToEntity(proDTO);

			productDAO.updateProduct(sp);
		}
	}

	@Override
	public void deleteProductByMaSp(String maSp) throws Exception {
		ProductDTO dto = getProuctByMaSp(maSp);
		if (dto != null) {
			productDAO.deleteProductByMaSp(maSp);
		}

	}

	@Override
	public ProductDTO getProuctByMaSp(String maSp) throws Exception {
		SanPham sp = productDAO.getProuctByMaSp(maSp);
		ProductDTO dto = mapFetchEagerEntityToDTO(sp);

		return dto;
	}

	@Override
	public List<ProductDTO> getAllProduct() throws Exception {
		List<SanPham> sanphams = productDAO.getAllProduct();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanphams.forEach((sp) -> {
			ProductDTO dto = mapFetchEagerEntityToDTO(sp);
			productDTOs.add(dto);
		});
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getTopProduct(int soLuong) throws Exception {
		List<SanPham> sanphams = productDAO.getTopProduct(soLuong);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanphams.forEach((sp) -> {
			ProductDTO dto = mapFetchLazyEntityToDTO(sp);
			productDTOs.add(dto);
		});
		return productDTOs;
	}

	@Override
	public List<ProductDetailDTO> getAllProductDetailByMaSP(String maSP) throws Exception {
		SanPham sp = productDAO.getProuctByMaSp(maSP);
		List<ChiTietSanPham> ctsps = productDAO.getAllProductDetailByMaSP(maSP);
		if (sp != null) {
			ProductDTO dto = mapFetchEagerEntityToDTO(sp);
			List<ProductDetailDTO> proDetails = dto.getDetailDTOs();

			return proDetails;
		}
		return null;
	}

	@Override
	public List<ProductDTO> getProductLimit(int index, int limit) throws Exception {
		List<SanPham> sanphams = productDAO.getProductLimit(index, limit);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanphams.forEach((sp) -> {
			ProductDTO dto = mapFetchEagerEntityToDTO(sp);
			productDTOs.add(dto);
		});

		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductLimitAndCategory(int category, int index, int limit) throws Exception {
		DanhMuc danhMuc = new DanhMuc();
		danhMuc.setMaDanhMuc(category);

		List<SanPham> sanphams = productDAO.getProductLimitAndCategory(danhMuc, index, limit);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		sanphams.forEach((sp) -> {
			ProductDTO dto = mapFetchLazyEntityToDTO(sp);
			productDTOs.add(dto);
		});

		return productDTOs;
	}

	@Override
	public int countAllProduct() throws Exception {
		List<SanPham> sp = productDAO.getAllProduct();
		if (sp != null) {
			return sp.size();
		}
		return 0;
	}

	private SanPham mapDTOToEntity(ProductDTO dto) {
		SanPham sp = new SanPham();
		sp.setMaSP(dto.getMaSp());
		sp.setTenSP(dto.getTenSp());
		sp.setMoTa(dto.getMoTa());
		sp.setGia(dto.getGia());
		sp.setAnhMoTa(dto.getTenAnh());

		DanhMuc dm = new DanhMuc();
		dm.setMaDanhMuc(dto.getCategory().getId());
		sp.setDanhMuc(dm);

		List<ChiTietSanPham> ctsps = new ArrayList<ChiTietSanPham>();
		for (ProductDetailDTO pDetailDTO : dto.getDetailDTOs()) {
			ColorDTO colorDTO = pDetailDTO.getColor();
			MauSac mauSac = new MauSac();
			mauSac.setMaMau(colorDTO.getId());
//			mauSac.setTenMau(colorDTO.getColor());

			SizeDTO sizeDTO = pDetailDTO.getSize();
			SizeSanPham sizeSanPham = new SizeSanPham();
			sizeSanPham.setMaSize(sizeDTO.getId());
//			sizeSanPham.setSize(sizeDTO.getSize());

			ChiTietSanPham ctsp = new ChiTietSanPham();
			String idCt = dto.getMaSp() + colorDTO.getId() + sizeDTO.getId();
			ctsp.setIdChiTiet(idCt);
			ctsp.setSanPham(sp);
			ctsp.setMauSac(mauSac);
			ctsp.setSizeSanPham(sizeSanPham);
			ctsp.setSoLuong(pDetailDTO.getAmount());

			ctsps.add(ctsp);
		}
		sp.setChiTietSanPhams(ctsps);

		return sp;
	}

	private ProductDTO mapFetchLazyEntityToDTO(SanPham sp) {
		DanhMuc dm = sp.getDanhMuc();
		CategoryDTO catDto = new CategoryDTO();
		catDto.setId(dm.getMaDanhMuc());
		catDto.setName(dm.getTenDanhMuc());
		catDto.setImage(dm.getHinhAnh());
		
		ProductDTO dto = new ProductDTO();
		dto.setMaSp(sp.getMaSP());
		dto.setTenSp(sp.getTenSP());
		dto.setMoTa(sp.getMoTa());
		dto.setGia(sp.getGia());
		dto.setTenAnh(sp.getAnhMoTa());
		dto.setCategory(catDto);
		
		return dto;
	}
	
	private ProductDTO mapFetchEagerEntityToDTO(SanPham sp) {
		DanhMuc dm = sp.getDanhMuc();
		CategoryDTO catDto = new CategoryDTO();
		catDto.setId(dm.getMaDanhMuc());
		catDto.setName(dm.getTenDanhMuc());
		catDto.setImage(dm.getHinhAnh());

		List<ProductDetailDTO> details = new ArrayList<ProductDetailDTO>();
		for (ChiTietSanPham ctsp : sp.getChiTietSanPhams()) {
			MauSac mauSac = ctsp.getMauSac();
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setId(mauSac.getMaMau());
			colorDTO.setColor(mauSac.getTenMau());

			SizeSanPham sizeSP = ctsp.getSizeSanPham();
			SizeDTO sizeDTO = new SizeDTO();
			sizeDTO.setId(sizeSP.getMaSize());
			sizeDTO.setSize(sizeSP.getSize());

			ProductDetailDTO detailDTO = new ProductDetailDTO();
			detailDTO.setId(ctsp.getIdChiTiet());
			detailDTO.setAmount(ctsp.getSoLuong());
			detailDTO.setColor(colorDTO);
			detailDTO.setSize(sizeDTO);

			details.add(detailDTO);
		}

		ProductDTO dto = new ProductDTO();
		dto.setMaSp(sp.getMaSP());
		dto.setTenSp(sp.getTenSP());
		dto.setMoTa(sp.getMoTa());
		dto.setGia(sp.getGia());
		dto.setTenAnh(sp.getAnhMoTa());
		dto.setCategory(catDto);
		dto.setDetailDTOs(details);

		return dto;
	}
}
