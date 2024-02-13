package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class ValidateIdController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		
		int cnt = UserDAO.getInstance().checkId(id);
		String value = "";
		
		if(cnt == 0) {
			value = "valid";
		}else {
			value = "notvalid";
		}
		
		response.getWriter().print(value);
		return null;
	}

}
