package com.duong.uitils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ReadWrite {
//	
//	@Autowired
//	Environment environment;
	
	private final String PATH_IMAGE_PRODUCTS = "D:\\BuildAppJava\\ImageProducts\\";
	public void writeFile(String fileName, MultipartFile file) throws IOException {
		String fileAndName = PATH_IMAGE_PRODUCTS + fileName;
		FileOutputStream outputStream = new FileOutputStream(fileAndName);
		outputStream.write(file.getBytes());
		outputStream.close();
	}
	public void saveImageProduct(MultipartFile file) throws IOException {
		String filename = file.getOriginalFilename();
		writeFile(filename, file);
	}
}
