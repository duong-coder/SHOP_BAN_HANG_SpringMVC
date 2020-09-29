package com.duong.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hoadon")
public class DonHang implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "MaHoaDon")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maHD;
	
	@ManyToOne
	@JoinColumn(name = "MaNguoiDung")
	private NguoiDung nguoiDung;
	
	@Column(name = "NgayMua")
	private Date ngayMua;
	
	@Column(name = "TinhTrang")
	private boolean tinhTrang;
	
	@Column(name = "DiaChiGiaoHang")
	private String diaChi;
	
	@OneToMany(mappedBy="donHang")
	private List<ChiTietDonHang> chiTietDonHangs;
	
	public DonHang() {
		// TODO Auto-generated constructor stub
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public void setChiTietDonHangs(List<ChiTietDonHang> cTDHs) {
		this.chiTietDonHangs = cTDHs;
	}
	
	public List<ChiTietDonHang> getChiTietDonHangs(){
		return this.chiTietDonHangs;
	}
}
