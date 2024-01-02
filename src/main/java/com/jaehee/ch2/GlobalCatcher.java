package com.jaehee.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.jaehee.ch2") // 해당 패키지 내에서만 @어노테이션 적용됨
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) { // 발생한 예외를 view로 보내주려면 model객체 필요함
		m.addAttribute("ex", ex); // 자동으로 ex정보를 m에 담아서 view에 전달함
		return "error";
	}
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex); 
		return "error";
	}
}
