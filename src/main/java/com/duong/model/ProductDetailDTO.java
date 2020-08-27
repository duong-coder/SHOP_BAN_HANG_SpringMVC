package com.duong.model;

import java.util.List;

public class ProductDetailDTO {
//	private int idProductDetail;
	private ProductDTO productDTO;
	private ColorDTO color;
//	private List<ColorDTO> colors;
	private SizeDTO size;
//	private List<SizeDTO> sizes;
	private int amount;
//	private List<Integer> amounts;
	
	
//	public int getIdProductDetail() {
//		return idProductDetail;
//	}
//	public void setIdProductDetail(int idProductDetail) {
//		this.idProductDetail = idProductDetail;
//	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public ColorDTO getColor() {
		return color;
	}
	public void setColor(ColorDTO color) {
		this.color = color;
	}
//	public List<ColorDTO> getColors() {
//		return colors;
//	}
//	public void setColors(List<ColorDTO> colors) {
//		this.colors = colors;
//	}
	public SizeDTO getSize() {
		return size;
	}
	public void setSize(SizeDTO size) {
		this.size = size;
	}
//	public List<SizeDTO> getSizes() {
//		return sizes;
//	}
//	public void setSizes(List<SizeDTO> sizes) {
//		this.sizes = sizes;
//	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
//	public List<Integer> getAmounts() {
//		return amounts;
//	}
//	public void setAmount(List<Integer> amounts) {
//		this.amounts = amounts;
//	}
	
}
