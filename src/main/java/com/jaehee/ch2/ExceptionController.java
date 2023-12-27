package com.jaehee.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	
	// 별도의 예외처리 메소드이며, 해당 컨트롤러 내에서만 쓸 수 있음 (try-catch 역할을 해줌!)
	// 그래서 별도의 클래스에 @ControllerAdvice를 쓰면 모든 컨트롤러에서 발생하는 예외를 다 처리해줌 = GlobalCatcher
	// 해당 컨트롤러는 @GlobalCatcher 메소드가 아닌 가장 가까운 아래 예외처리 catcher메소드가 실행됨!!!
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500 상태코드 변경
	public String catcher(Exception ex, Model m) { // 발생한 예외를 view로 보내주려면 model객체 필요함
		System.out.println("catcher() in ExceptionController"); // 어디서 예외처리해주는지 확인~
		
		// JSP에서 <%@ page isErrorPage="true"/> 적어주면 ex 담아서 전달할 필요없음! 생략 가능함!
//		m.addAttribute("ex", ex); // 자동으로 ex정보를 m에 담아서 view에 전달함
		return "error";
	}
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex); 
		return "error";
	}
	
	//-----------------------------------------------------------
	
	@RequestMapping("/ex")
	public String main() throws Exception{
//		try {
			throw new Exception("예외가 발생했습니다."); // 우클릭 Surround with>Try/Catch Block
//		} catch (Exception e) {
//			return "error";
//		}
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception{
//		try {
			throw new NullPointerException("예외가 발생했습니다."); // 우클릭 Surround with>Try/Catch Block
//		} catch (Exception e) {
//			return "error";
//		}
	}
	@RequestMapping("/ex3")
	public String main3() throws Exception{	// 예외처리 메소드 없어도 조상인 Exception이 처리해줌!
			throw new FileNotFoundException("예외가 발생했습니다."); // 우클릭 Surround with>Try/Catch Block
	}
}
