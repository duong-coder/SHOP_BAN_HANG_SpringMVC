package com.duong.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the mausac database table.
 * 
 */
@Entity
@Table(name = "mausac")
public class MauSac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maMau;
	
	@Column(name = "TenMau")
	private String tenMau;
	
	@OneToMany(mappedBy="mauSac")
	private List<ChiTietSanPham> chiTietSanPhams;

	
	public MauSac() {
	}

	public int getMaMau() {
		return this.maMau;
	}

	public void setMaMau(int maMau) {
		this.maMau = maMau;
	}

	public String getTenMau() {
		return this.tenMau;
	}

	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}

	public List<ChiTietSanPham> getChiTietSanPhams() {
		return chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}
	
}