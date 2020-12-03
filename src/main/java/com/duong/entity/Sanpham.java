package com.duong.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the sanpham database table.
 * 
 */
@Entity
@Table(name = "sanpham")
public class SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaSP")
	private String maSP;
	
	@Column(name = "AnhMoTa")
	private String anhMoTa;
	
	@Column(name = "Gia")
	private double gia;
	
	@Column(name = "MoTa")
	private String moTa;
	
	@Column(name = "TenSP")
	private String tenSP;
	
	@ManyToOne
	@JoinColumn(name = "MaDanhMuc")
	private DanhMuc danhMuc;
	
	@OneToMany(mappedBy="sanPham", cascade = CascadeType.ALL)
	private List<ChiTietSanPham> chiTietSanPhams;

	public SanPham() {
	}

	public String getMaSP() {
		return this.maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getAnhMoTa() {
		return this.anhMoTa;
	}

	public void setAnhMoTa(String anhMoTa) {
		this.anhMoTa = anhMoTa;
	}

	public double getGia() {
		return this.gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTenSP() {
		return this.tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	
	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public List<ChiTietSanPham> getChiTietSanPhams() {
		return chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}
	

}