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

@Controller // ctrl+shift+o �ڵ� import
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder // �ش� Controller �������� ���� ����
	public void toDate(WebDataBinder binder) {
		// Spring���� WebDataBinder�� DefaultFormattingConversion Service�� ���� �⺻ ��� �Ǿ�����
		ConversionService conversionService = binder.getConversionService();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // @DateTimeFormat�̶� ����
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false)); // ��������
		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#")); // ������ #���� ����	
	}
	
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
//	@GetMapping("/add") servlet-context.xml���� view-controller �ۼ� ����
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/save") // sts 4.3�������� ������ (����  ch2������Ʈ pom.xml���� 5.0.7�� ������ ch2��Ŭ��>Maven>update project���ֱ� 
	public String save(User user, BindingResult result, Model m) throws Exception {
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
		return true; // � ���̵� ��й�ȣ�� �Է��ص� ����ϵ���
	}
}
