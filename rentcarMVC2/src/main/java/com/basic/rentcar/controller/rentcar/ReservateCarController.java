package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;

import combasic.rentcar.vo.Rentcar;


public class ReservateCarController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath();
		
		HttpSession session = request.getSession();
		// 예약한 값을 db에다가 저장
		int no = Integer.parseInt(request.getParameter("num"));
		String id = (String)session.getAttribute("logId");
		int qty = Integer.parseInt(request.getParameter("qty"));
		int dday = Integer.parseInt(request.getParameter("dday"));
		String rday = request.getParameter("rday");
		int usein = Integer.parseInt(request.getParameter("usein"));
		int usewifi = Integer.parseInt(request.getParameter("usewifi"));
		int usenavi = Integer.parseInt(request.getParameter("usenavi"));
		int useseat = Integer.parseInt(request.getParameter("useseat"));

		int cnt1 = ReservationDAO.getinstance().carReservate(no, id, qty, dday, rday, usein, usewifi, usenavi, useseat);
		// 저장후 예약한 차수만큼 cnt 다운시키기
		int cnt2 = RentCarDAO.getInstance().carReservateCntDown(qty, no);
		
		Rentcar car = RentCarDAO.getInstance().getCarInfo(no);
		// 그리고 최종 금액값 계산
		int totalcar = car.getPrice() * qty * dday;
		// 옵션
		if(usein == 1) {
			usein = 10000;
		}else {
			usein = 0;
		}
		
		if(usewifi == 1) {
			usewifi = 10000;
		}else {
			usewifi = 0;
		}
		
		if(useseat == 1) {
			useseat = 10000;
		}else {
			useseat = 0;
		}
		//옵션 최종값
		int totalOption = (qty * dday *(usein + usewifi + useseat));
		
		request.setAttribute("totalCar", totalcar);
		request.setAttribute("totalOption", totalOption);
		
		request.setAttribute("img", car.getImg());
		
		// 최종결과창으로 보내기
		if(cnt1 > 0 && cnt2 > 0) {
			return "rentcar/reserveCarView";
		}else {
			throw new ServletException();
		}
	}

}
