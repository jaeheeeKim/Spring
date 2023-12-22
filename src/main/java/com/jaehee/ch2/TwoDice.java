package com.jaehee.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ctrl+shift+O �� �ڵ� import
public class TwoDice { // ���� �� ������ ����� ���� (���� ���ҽ�-���α׷�,��Ʈ����) // �̹����� ���� ���ҽ�(*.js, *.css, *.html)
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {
		int idx1 = (int)(Math.random()*6)+1; // ���� ���̽� �̹���1
		int idx2 = (int)(Math.random()*6)+1; // Toggle BreakPoint(�ߴ���) ������ > debug on server����
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.println("<img src='resources/img/dice"+idx1+".jpg'>");
		out.println("<img src='resources/img/dice"+idx2+".jpg'>");		
		out.print("</body>");
		out.print("</html>");

	}
}

/* 2023.12.18 ������
 * ch2 04.HTTP ��û�� ���� - ����
 * �������� ��û�� �ϸ� ������ �����Ͽ� ���α׷� ����
 * ����� html���� ����(text������)
 * �������� ��� ������ �ؼ��ؼ� �����ִ°���
 * 3. Ŭ���̾�Ʈ�� ����
 * Ŭ���̾�Ʈ(client): ���񽺸� ��û�ϴ� ���ø����̼�
 * ����(server): ���񽺸� �����ϴ� ���ø����̼�
 * 
 * �ѤѤѤѤѤѤѤѤѤѤѤѤ�
 * 
 * ch2 05.Ŭ���̾�Ʈ�� ����
 * �������� �̿��ؼ� ��û�ϸ� ��Ĺ�� ��ü�� �����ؼ� ������ ������ request��ü�� ��Ƽ� main�޼ҵ带 ����
 * Iterator(new) = Enumeration(old)
 * ?year=2021&year=2022&year=2023 ó�� ������Ʈ��(QueryString) �̸��� �� ���� ��� String[] yearArr = request.getParameterValues("year"); �� ���� �� ����
 * 
 * 1. Ŭ���̾�Ʈ�� ����
 * Ŭ���̾�Ʈ(client): ���񽺸� ��û�ϴ� ���ø����̼�
 * ����(server): ���񽺸� �����ϴ� ���ø����̼� 
 * 2. ������ ����
 * Email server, File server, Web server
 * 3. ������ ��Ʈ
 * 1���� PC�� ���� ������ �����ϱ⶧���� �̶� �ʿ��� ���� �ٷ� ��Ʈ��ȣ�� 111.22.33.44:25(email server) 111.22.33.44:22(file server) 111.22.33.44:80(web server) 
 * 80 ��Ʈ��ȣ�� ��������
 * ���ε� �Ǿ��ִ� �� ������ �� ��Ʈ��ȣ�� ����Ǿ�����(���� ���α׷��� �����Ҷ��� Ư�� ��Ʈ�ϰ� ����Ǿ ���ε��Ǿ� ��û�� ��ٸ� ���°� ������ ���°� �Ǵ°�)
 * 0~1023�� �̹� ����� ��Ʈ��ȣ / �� ���� 65535���� ��Ʈ��ȣ ��밡����
 * 4. �� ���ø����̼� ����(WAS)��?
 * WAS(Web Applicaion Server): �� ���ø����̼��� �����ϴ� ����(������ ���α׷��� ��ġ�ϰ� Ŭ���̾�Ʈ�� �� ���α׷��� ����� �� �ְ� ����)
 * Ŭ���̾�Ʈ���� �������α׷� ȣ���ϸ� tomcat ���� WAS�� �������� �������� 
 * 5. tomcat�� ���� ����
 * servlet�� ���� ���� ���α׷���
 **** �� �κп� tomcat ���� ���� �� �������ֽ�
 *
 *�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
 *
 * 6. ���� ���� - server.xml, web.xml
 * <�������α׷�> �缭�� ���(@Controller) ��URL����(@RequestMapping)
 *
 */
