package com.basic.rentcar.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.UserDAO;
import com.basic.rentcar.frontController.Controller;

public class LoginCheckController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") == null) {
			return "user/login";
		}

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int cnt = 0;

		response.setContentType("text/html; charset-UTF-8");

		if (id.equals("admin") && pw.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("logId", id);
			response.getWriter().print(id);
		} else {
			cnt = UserDAO.getInstance().checkLogin(id, pw);

			if (cnt > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("logId", id);
				response.getWriter().print(cnt);
			} else {
				response.getWriter().print(cnt);
			}
		}
		return null;
	}

}
