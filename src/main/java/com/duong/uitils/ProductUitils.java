package com.duong.uitils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	public static void main(String[] args) {
		getInforProduct("Màn hình: OLED, 6.5\", Super Retina XDR; Hệ điều hành: iOS 13; Camera sau: 3 camera 12 MP");
	}
}
