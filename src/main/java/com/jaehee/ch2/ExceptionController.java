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
	
	// ������ ����ó�� �޼ҵ��̸�, �ش� ��Ʈ�ѷ� �������� �� �� ���� (try-catch ������ ����!)
	// �׷��� ������ Ŭ������ @ControllerAdvice�� ���� ��� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ� �� ó������ = GlobalCatcher
	// �ش� ��Ʈ�ѷ��� @GlobalCatcher �޼ҵ尡 �ƴ� ���� ����� �Ʒ� ����ó�� catcher�޼ҵ尡 �����!!!
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 -> 500 �����ڵ� ����
	public String catcher(Exception ex, Model m) { // �߻��� ���ܸ� view�� �����ַ��� model��ü �ʿ���
		System.out.println("catcher() in ExceptionController"); // ��� ����ó�����ִ��� Ȯ��~
		
		// JSP���� <%@ page isErrorPage="true"/> �����ָ� ex ��Ƽ� ������ �ʿ����! ���� ������!
//		m.addAttribute("ex", ex); // �ڵ����� ex������ m�� ��Ƽ� view�� ������
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
			throw new Exception("���ܰ� �߻��߽��ϴ�."); // ��Ŭ�� Surround with>Try/Catch Block
//		} catch (Exception e) {
//			return "error";
//		}
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception{
//		try {
			throw new NullPointerException("���ܰ� �߻��߽��ϴ�."); // ��Ŭ�� Surround with>Try/Catch Block
//		} catch (Exception e) {
//			return "error";
//		}
	}
	@RequestMapping("/ex3")
	public String main3() throws Exception{	// ����ó�� �޼ҵ� ��� ������ Exception�� ó������!
			throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�."); // ��Ŭ�� Surround with>Try/Catch Block
	}
}
