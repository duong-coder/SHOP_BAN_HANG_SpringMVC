package com.duong.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private String maSp;
	private String tenSp;
	private String moTa;
	private double gia;
	private String tenAnh;
	private CategoryDTO category;
	private MultipartFile file;
	private List<ProductDetailDTO> detailDTOs;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getMaSp() {
		return maSp;
	}

	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getTenAnh() {
		return tenAnh;
	}

	public void setTenAnh(String tenAnh) {
		this.tenAnh = tenAnh;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public List<ProductDetailDTO> getDetailDTOs() {
		return detailDTOs;
	}

	public void setDetailDTOs(List<ProductDetailDTO> detailDTOs) {
		this.detailDTOs = detailDTOs;
	}
	
	
}
