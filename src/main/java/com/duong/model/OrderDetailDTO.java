package com.duong.model;

public class OrderDetailDTO {
	private String maHDCT;
	private ProductDetailDTO productDetail;
	private int amount;
	
	
	public String getMaHDCT() {
		return maHDCT;
	}
	public void setMaHDCT(String maHDCT) {
		this.maHDCT = maHDCT;
	}
	public ProductDetailDTO getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(ProductDetailDTO productDetail) {
		this.productDetail = productDetail;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
