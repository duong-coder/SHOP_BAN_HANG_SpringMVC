package com.duong.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private String maSp;
	private String tenSp;
	private String moTa;
	private double gia;
	private int soLuong;
	private String tenAnh;
	private MultipartFile file;
	
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

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenAnh() {
		return tenAnh;
	}

	public void setTenAnh(String tenAnh) {
		this.tenAnh = tenAnh;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
