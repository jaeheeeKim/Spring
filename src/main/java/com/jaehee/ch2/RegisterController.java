package com.jaehee.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ctrl+shift+o 자동 import
public class RegisterController {
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // sts 4.3버전부터 가능함 (따라서  ch2프로젝트 pom.xml에서 5.0.7로 수정후 ch2우클릭>Maven>update project해주기 
	public String save(User user, Model m) throws Exception {
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
		return false;
	}
}
