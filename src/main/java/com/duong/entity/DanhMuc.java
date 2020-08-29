package com.duong.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the mausac database table.
 * 
 */
@Entity
@Table(name = "danhmucsanpham")
public class DanhMuc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maDanhMuc;
	
	@Column(name = "TenDanhMuc")
	private String tenDanhMuc;
	
	@Column(name = "HinhAnh")
	private String hinhAnh;
	
	@OneToMany(mappedBy="danhMuc")
	private List<SanPham> sanPhams;

	
	public DanhMuc() {
	}


	public int getMaDanhMuc() {
		return maDanhMuc;
	}


	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}


	public String getTenDanhMuc() {
		return tenDanhMuc;
	}


	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}


	public String getHinhAnh() {
		return hinhAnh;
	}


	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}


	public List<SanPham> getSanPhams() {
		return sanPhams;
	}


	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

}