package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;

import combasic.rentcar.vo.Rentcar;

public class InsertCarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		int category= Integer.parseInt(request.getParameter("categroy"));
		int price = Integer.parseInt(request.getParameter("price"));
		int usepeople = Integer.parseInt(request.getParameter("usepeople"));
		int totalQty = Integer.parseInt(request.getParameter("totalQty"));
		String company = request.getParameter("company");
		String img = request.getParameter("imgurl");
		String info = request.getParameter("info");
		
		Rentcar car = new Rentcar(0, name, category, price, usepeople, totalQty, company, img, info);
		
		int cnt = RentCarDAO.getInstance().carInsert(car);
		// 시험적으로 사용되기에 1번만 추가하고 없어지기
		if(cnt > 0) {
			HttpSession session = request.getSession();
			session.removeAttribute("logId");
			return "main";
		}else {
			throw new ServletException();
		}
		
	}

}
