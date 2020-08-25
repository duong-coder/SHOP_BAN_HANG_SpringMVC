package com.duong.model;

public class SizeDTO {
	private int id;
	private String size;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SizeDTO) {
			SizeDTO sizeDTO2 = (SizeDTO) obj;
			if(this.id == sizeDTO2.getId()){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id + 30;
	}
	
}
