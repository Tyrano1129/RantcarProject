package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class JoinUserController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("id") == null) {
			return "user/join";
		}
		
		String ctx = request.getContextPath();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		String tel = request.getParameter("tel");
		String info = request.getParameter("info");
		String hobby = request.getParameter("hobby");
		String email = request.getParameter("email");
		
		int cnt = UserDAO.getInstance().joinMember(id, pw, email, age, job, tel, hobby, info);
		
		if(cnt > 0) {
			return "re:"+ctx+"/main.do";
		}else {
			throw new ServletException();
		}
	}
	
}
