package com.duong.model;

public class ProductDetailDTO {
	private String id;
	private ProductDTO productDTO;
	private ColorDTO color;
	private SizeDTO size;
	private int amount;
	
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
//		if(!(id == null || id.trim().equals(""))) {
//			this.id = id;
//		}else {
//			this.id = this.productDTO.getMaSp() + this.color.getId() + this.size.getId();
//		}
		this.id = id;
	}
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
	public SizeDTO getSize() {
		return size;
	}
	public void setSize(SizeDTO size) {
		this.size = size;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
