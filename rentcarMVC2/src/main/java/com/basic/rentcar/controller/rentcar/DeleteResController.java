package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;

public class DeleteResController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("logId");
		int qty = Integer.parseInt(request.getParameter("qty"));
		int no = Integer.parseInt(request.getParameter("no"));
		int reserveSeq = Integer.parseInt(request.getParameter("reserveSeq"));
		
		int cnt1 = ReservationDAO.getinstance().deleteRes(reserveSeq, id);
		int cnt2 = RentCarDAO.getInstance().resDeleteCntUp(no, qty);
		
		if(cnt1 > 0 && cnt2 > 0) {
			response.getWriter().print(cnt2);
		}else {
			throw new ServletException();
		}
		
		return null;
	}

}
