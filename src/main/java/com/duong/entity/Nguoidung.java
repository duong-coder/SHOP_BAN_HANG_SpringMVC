package com.duong.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nguoidung database table.
 * 
 */
@Entity
@Table(name="nguoidung")
public class NguoiDung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "Email")
	private String email;
	
	@Column(name = "GioiTinh")
	private boolean gioiTinh;
	
	@Column(name = "HoTen")
	private String hoTen;
	
	@Column(name = "MaNguoiDung")
	private String maNguoiDung;
	
	@Column(name = "MatKhau")
	private String matKhau;
	
	@Column(name = "Role")
	private String role;
	
	@Column(name = "SoDT")
	private String soDT;
	
	@Column(name = "TinhTrang")
	private String tinhTrang;

	public NguoiDung() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaNguoiDung() {
		return this.maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSoDT() {
		return this.soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getTinhTrang() {
		return this.tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}