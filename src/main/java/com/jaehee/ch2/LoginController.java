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
		// 1. ������ ����
		session.invalidate();
		// 2. Ȩ���� �̵�
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@CookieValue("id") String cookieId, String id, String pwd, boolean rememberId, String toURL,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 1. id�� pwd�� Ȯ��
		// 2-1.��ġ����������, �ٽ� loginForm���� �̵�
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			
			return "redirect:/login/login?msg="+msg;
		}
		
		// 2-2. id�� pwd�� ��ġ�ϸ�, 
		// ���� ��ü�� ID�� ����
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		if(rememberId) {
			// ��Ű�� ����
			Cookie cookie = new Cookie("id", "asdf");
			// ���信 ����
			response.addCookie(cookie);
		}else {
			// ��Ű�� ����
			Cookie cookie = new Cookie("id", "asdf");
			cookie.setMaxAge(0);
			// ���信 ����
			response.addCookie(cookie);			
		}
		//Ȩ���� �̵�								//Ȩ����	//url��ġ��
		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
		
		return "redirect:"+toURL;
	}
	
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id) && "1234".equals(pwd); // �ٲ㼭 �ۼ��ϸ� null üũ ���ص� ��
	}
}
