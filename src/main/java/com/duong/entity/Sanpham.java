package com.duong.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sanpham database table.
 * 
 */
@Entity
@Table(name = "sanpham")
public class Sanpham implements Serializable {
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
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@Column(name = "TenSP")
	private String tenSP;

	public Sanpham() {
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

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenSP() {
		return this.tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

}