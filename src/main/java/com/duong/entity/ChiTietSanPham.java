package com.duong.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chitietsanpham database table.
 * 
 */
@Entity
@Table(name = "chitietsanpham")
public class ChiTietSanPham implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int idChiTiet;
	
//	@Column(name = "MaMau")
	@Id
	@ManyToOne
	@JoinColumn(name = "MaMau")
	private MauSac mauSac;
	
//	@Column(name = "MaSize")
	@Id
	@ManyToOne
	@JoinColumn(name = "MaSize")
	private SizeSanPham sizeSP;
	
	@Column(name = "soLuong")
	private int soLuong;
	
//	@Column(name = "MaSP")
	@Id
	@ManyToOne
	@JoinColumn(name = "MaSP")
	private SanPham sanPham;

	public ChiTietSanPham() {
	}

//	public int getIdChiTiet() {
//		return this.idChiTiet;
//	}
//
//	public void setIdChiTiet(int idChiTiet) {
//		this.idChiTiet = idChiTiet;
//	}

	public MauSac getMauSac() {
		return this.mauSac;
	}

	public void setMauSac(MauSac maMau) {
		this.mauSac = maMau;
	}

	public SizeSanPham getSizeSanPham() {
		return this.sizeSP;
	}

	public void setSizeSanPham(SizeSanPham maSize) {
		this.sizeSP = maSize;
	}
	
	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public SanPham getSanPham() {
		return this.sanPham;
	}

	public void setSanPham(SanPham maSP) {
		this.sanPham = maSP;
	}

}