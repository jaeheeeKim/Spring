package com.jaehee.ch2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
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
//		binder.setValidator(new UserValidator()); // UserValidator를 WebDataBinder의 로컬 validator로 등록
//		binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators(); // 글로벌 Validator만 나옴
		System.out.println("validatorList="+validatorList);
	}
	
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
//	@GetMapping("/add") servlet-context.xml에서 view-controller 작성 가능
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/save") // sts 4.3버전부터 가능함 (따라서  ch2프로젝트 pom.xml에서 5.0.7로 수정후 ch2우클릭>Maven>update project해주기 
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
					// @Valid는 pom.xml에 등록해줘야함
		
		// 수동 검증 - Validator를 직접 생성하고, validate()를 직접 호출
		// (아래 유효성 검사 대신 local Validator로 ★수동 검증★)
//		UserValidator userValidator - new UserValidator();
//		userValidator.validate(user, result); // BindingResult는 Errors의 자손
		
		// User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야함
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		// 1. 유효성 검사
//		if(!isValid(user)) {
//			// URLEncoder :사용자가 직접 url에 한글 작성하면 encode 해줌
//			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8"); // registerForm.jsp에서 decoder 해줘야함
//			
//			m.addAttribute("msg", msg);
//			return "redirect:/register/add";
////		return "redirect:/register/add?msg="+msg; // URL 재작성(rewriting)
//		}
		
		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true; // 어떤 아이디나 비밀번호를 입력해도 통과하도록
	}
}
