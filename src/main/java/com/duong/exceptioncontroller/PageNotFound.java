package com.duong.exceptioncontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class PageNotFound {
	
//	@ExceptionHandler(value = {NoHandlerFoundException.class})
//	public String getPageNotFound(Exception exception) {
//		System.out.println("ko tim thay trang");
//		return "hello";
//	}
	@ExceptionHandler(value = {NoHandlerFoundException.class})
	public ResponseEntity<String> getPageNotFound(Exception exception) {
		System.out.println("ko tim thay trang");
        return new ResponseEntity<String>("Loi", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> exceptionALLHandler(Exception exception) {
//		logger.info("Loi truy van");
		System.out.println("loi");
		return new ResponseEntity<String>("Loi", HttpStatus.CONFLICT);
	}
}
