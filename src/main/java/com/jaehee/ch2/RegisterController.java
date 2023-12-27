package com.jaehee.ch2;

import java.net.URLEncoder;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o 자동 import
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder // 해당 Controller 내에서만 적용 가능
	public void toDate(WebDataBinder binder) {
		// Spring에는 WebDataBinder에 DefaultFormattingConversion Service가 많이 기본 등록 되어있음
		ConversionService conversionService = binder.getConversionService();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // @DateTimeFormat이랑 같음
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false)); // 날자형식
		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#")); // 구분자 #으로 나눔	
	}
	
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
//	@GetMapping("/add") servlet-context.xml에서 view-controller 작성 가능
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/save") // sts 4.3버전부터 가능함 (따라서  ch2프로젝트 pom.xml에서 5.0.7로 수정후 ch2우클릭>Maven>update project해주기 
	public String save(User user, BindingResult result, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
						// URLEncoder :사용자가 직접 url에 한글 작성하면 encode 해줌
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8"); // registerForm.jsp에서 decoder 해줘야함
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL 재작성(rewriting)
		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true; // 어떤 아이디나 비밀번호를 입력해도 통과하도록
	}
}
