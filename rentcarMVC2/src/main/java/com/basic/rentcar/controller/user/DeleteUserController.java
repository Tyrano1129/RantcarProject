package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class DeleteUserController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		int cnt = UserDAO.getInstance().userOneDelete(id);
		
		if(cnt > 0) {
			HttpSession session = request.getSession();
			session.removeAttribute("logId");
			response.getWriter().print(cnt);
		}else {
			throw new ServletException();
		}
		return null;
	}

}
