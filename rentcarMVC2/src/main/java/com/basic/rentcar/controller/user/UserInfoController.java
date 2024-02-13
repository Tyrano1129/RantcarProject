package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

import combasic.rentcar.vo.User;

public class UserInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("logId");
		
		User user = UserDAO.getInstance().userOneInfo(id);

		request.setAttribute("vo", user);
		
		return "user/userInfo";
	}

}
