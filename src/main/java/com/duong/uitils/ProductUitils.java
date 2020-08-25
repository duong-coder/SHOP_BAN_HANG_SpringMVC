package com.duong.uitils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.duong.entity.ChiTietSanPham;
import com.duong.entity.SizeSanPham;
import com.duong.model.ColorDTO;
import com.duong.model.ProductDetailDTO;
import com.duong.model.SizeDTO;

public class ProductUitils {
	public static Map<String, String> getInforProduct(String moTa){
		Map<String, String> map = new HashMap<String, String>();
		
		String[] moTas = moTa.split("; ");
		for(String s:moTas) {
			String[] itemMoTa = s.split(": ");
			map.put(itemMoTa[0], itemMoTa[1]);
		}
		
		for(Entry<String, String> entry:map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		
		return map;
	}
//	public static Set<String> getSizeProduct(List<ProductDetailDTO> ctsps){
//		Set<String> sizes = new HashSet<String>();
//		ctsps.forEach((ctsp) -> {
//			String size = ctsp.getSize().getSize();
//			sizes.add(size);
//		});
//		return sizes;
//	}
	public static Set<SizeDTO> getSizeProduct(List<ProductDetailDTO> ctsps){
		Set<SizeDTO> sizes = new HashSet<SizeDTO>();
		ctsps.forEach((ctsp) -> {
			SizeDTO size = ctsp.getSize();
			sizes.add(size);
		});
		return sizes;
	}
//	public static Set<String> getColorProduct(List<ProductDetailDTO> ctsps){
//		Set<String> colors = new HashSet<String>();
//		ctsps.forEach((ctsp) -> {
//			String size = ctsp.getColor().getColor();
//			colors.add(size);
//		});
//		return colors;
//	}
	public static Set<ColorDTO> getColorProduct(List<ProductDetailDTO> ctsps){
		Set<ColorDTO> colors = new HashSet<ColorDTO>();
		ctsps.forEach((ctsp) -> {
			ColorDTO size = ctsp.getColor();
			colors.add(size);
		});
		return colors;
	}
	public static void main(String[] args) {
		getInforProduct("Màn hình: OLED, 6.5\", Super Retina XDR; Hệ điều hành: iOS 13; Camera sau: 3 camera 12 MP");
	}
}
