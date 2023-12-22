package com.jaehee.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC5 { // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC5")
	//public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main(@ModelAttribute("myDate") Mydate date, Model model) throws IOException {
											// ������ �Ű����� �տ� @ModelAttribute ����
		// 1. ��ȿ�� �˻�
		if(!isvalid(date))
			return "yoilError";
		
		// 2. ���� ���
//		char yoil = getYoil(date);
		
		// 3. ����� ����� model�� ����
//		model.addAttribute("myDate", date);
//		model.addAttribute("yoil", yoil);
		
		return "yoil4"; // "WEB-INF/views/yoil.jsp" �ش� ��δ� appServlet�� servlet-context.xml ������ ��������
	}

	private boolean isvalid(Mydate date) {
		return isvalid(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isvalid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true; //false�� ��� Error�������� ��!
	}

	private @ModelAttribute("yoil") char getYoil(Mydate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}
	
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day-1);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������, 3:ȭ����...
		return "�Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}
