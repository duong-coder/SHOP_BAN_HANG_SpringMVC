package com.duong.model;

public class ColorDTO {
	private int id;
	private String color;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ColorDTO) {
			ColorDTO colorDTO2 = (ColorDTO) obj;
			if(this.id == colorDTO2.getId()){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id + 31;
	}
}
