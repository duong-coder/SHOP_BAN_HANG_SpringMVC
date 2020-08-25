package com.duong.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.duong.model.ColorDTO;



/**
 * The persistent class for the sizesanpham database table.
 * 
 */
@Entity
@Table(name = "sizesanpham")
public class SizeSanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maSize;
	
	@Column(name = "Size")
	private String size;
	
	@OneToMany(mappedBy="sizeSP")
	private List<ChiTietSanPham> chiTietSanPhams;

	
	public SizeSanPham() {
	}

	public int getMaSize() {
		return this.maSize;
	}

	public void setMaSize(int maSize) {
		this.maSize = maSize;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<ChiTietSanPham> getChiTietSanPhams() {
		return chiTietSanPhams;
	}

	public void setChiTietSanPhams(List<ChiTietSanPham> chiTietSanPhams) {
		this.chiTietSanPhams = chiTietSanPhams;
	}

}