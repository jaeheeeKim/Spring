package com.jaehee.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YoilTellerMVC2 { // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2")
	//public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main(@RequestParam(required=true) int year, 
			@RequestParam(required=true) int month, 
			@RequestParam(required=true) int day, Model model) throws IOException {
		// 1. ��ȿ�� �˻�
		if(!isvalid(year,month, day))
			return "yoilError";
		
		//�Է� �κ� ����(�и�)��
		
		// 2. ���� ���
		char yoil = getYoil(year, month, day);
		/*�Ʒ� 4���� �����ؼ� ��Ŭ�� �� 'Refactor-Extract Method' getYoil(year, month, day);�κ���
		 * Calendar cal = Calendar.getInstance(); cal.set(yyyy, mm-1, dd-1);
		 * 
		 * int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������, 3:ȭ����... char
		 * yoil = "�Ͽ�ȭ�������".charAt(dayOfWeek);
		 */
		
		// 3. ����� ����� model�� ����
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; // "WEB-INF/views/yoil.jsp" �ش� ��δ� appServlet�� servlet-context.xml ������ ��������
		
		// ��� �κ� ����(�и�)��
	}

	private boolean isvalid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true; //false�� ��� Error�������� ��!
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day-1);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������, 3:ȭ����...
		return "�Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}
