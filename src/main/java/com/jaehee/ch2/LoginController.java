package com.jaehee.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 1. 세션을 종료
		session.invalidate();
		// 2. 홈으로 이동
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@CookieValue("id") String cookieId, String id, String pwd, boolean rememberId, String toURL,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 1. id와 pwd를 확인
		// 2-1.일치하지않으면, 다시 loginForm으로 이동
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		
		// 2-2. id와 pwd가 일치하면, 
		// 세션 객체에 ID를 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		if(rememberId) {
			// 쿠키를 생성
			Cookie cookie = new Cookie("id", "asdf");
			// 응답에 저장
			response.addCookie(cookie);
		}else {
			// 쿠키를 삭제
			Cookie cookie = new Cookie("id", "asdf");
			cookie.setMaxAge(0);
			// 응답에 저장
			response.addCookie(cookie);			
		}
		//홈으로 이동								//홈으로	//url위치로
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:"+toURL;
	}
	
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd); // 바꿔서 작성하면 null 체크 안해도 됨
	}
}
