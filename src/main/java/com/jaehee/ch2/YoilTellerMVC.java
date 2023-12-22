package com.jaehee.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC { // http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1
	
	@RequestMapping("/getYoilMVC")
	//public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main(int year, int month, int day, Model model) throws IOException {
		// 1. 유효성 검사
		if(!isvalid(year,month, day))
			return "yoilError";
		
		//입력 부분 제거(분리)함
		
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
		/*아래 4줄을 선택해서 우클릭 후 'Refactor-Extract Method' getYoil(year, month, day);부분임
		 * Calendar cal = Calendar.getInstance(); cal.set(yyyy, mm-1, dd-1);
		 * 
		 * int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일, 3:화요일... char
		 * yoil = "일월화수목금토".charAt(dayOfWeek);
		 */
		
		// 3. 계산한 결과를 model에 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil"; // "WEB-INF/views/yoil.jsp" 해당 경로는 appServlet의 servlet-context.xml 내에서 수정가능
		
		// 출력 부분 제거(분리)함
	}

	private boolean isvalid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true; //false일 경우 Error페이지로 감!
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day-1);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일, 3:화요일...
		return "일월화수목금토".charAt(dayOfWeek);
	}

}
