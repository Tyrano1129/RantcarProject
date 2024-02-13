package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

import combasic.rentcar.vo.User;

public class UpdateuserController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String job = request.getParameter("job");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String hobby = request.getParameter("hobby");
		String info = request.getParameter("info");
		
		System.out.println(id);
		int cnt = UserDAO.getInstance().userOneUpdate(id,job,tel,email,info,hobby);
		
		
		return "main";
	}

}
