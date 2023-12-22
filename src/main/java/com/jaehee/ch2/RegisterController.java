package com.jaehee.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // ctrl+shift+o �ڵ� import
public class RegisterController {
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm"; // WEB-INF/views/registerForm.jsp
//	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // sts 4.3�������� ������ (����  ch2������Ʈ pom.xml���� 5.0.7�� ������ ch2��Ŭ��>Maven>update project���ֱ� 
	public String save(User user, Model m) throws Exception {
		// 1. ��ȿ�� �˻�
		if(!isValid(user)) {
						// URLEncoder :����ڰ� ���� url�� �ѱ� �ۼ��ϸ� encode ����
			String msg = URLEncoder.encode("id�� �߸� �Է��ϼ̽��ϴ�.", "utf-8"); // registerForm.jsp���� decoder �������
			
			m.addAttribute("msg", msg);
			return "redirect:/register/add";
//			return "redirect:/register/add?msg="+msg; // URL ���ۼ�(rewriting)
		}
		
		// 2. DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
