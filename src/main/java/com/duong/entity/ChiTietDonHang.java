package com.duong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietDonHang implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "MaHoaDon")
	private DonHang donHang;
	
	@Column(name = "MaCTSP")
	private String cTSP;
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@Column(name = "GiaTien")
	private double giaTien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DonHang getDonhang() {
		return donHang;
	}

	public void setDonhang(DonHang donhang) {
		this.donHang = donhang;
	}

	public String getcTSP() {
		return cTSP;
	}

	public void setcTSP(String cTSP) {
		this.cTSP = cTSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	
	
}
