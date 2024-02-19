package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.dao.ReservationDAO;
import com.basic.rentcar.frontController.Controller;

import combasic.rentcar.vo.JoinCarView;
import combasic.rentcar.vo.Rentcar;
import combasic.rentcar.vo.Resevation;

public class UserReserveListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("logId");
		
		ArrayList<Resevation> list = ReservationDAO.getinstance().getUserReserveList(id);		
		
		request.setAttribute("list", list);
		
		ArrayList<JoinCarView> carResevelist = new ArrayList<JoinCarView>();
		
		for(int i = 0; i < list.size(); i+=1) {
			Rentcar car = RentCarDAO.getInstance().getCarUserList(list.get(i).getNo());
			int qty = list.get(i).getQty();
			int dday = list.get(i).getDday();
			int usein = list.get(i).getUserin();
			int usewifi = list.get(i).getUsewifi();
			int useseat = list.get(i).getUseseat();
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
			int total = totalOption + totalcar;
			request.setAttribute("totalCar", totalcar);
			request.setAttribute("totalOption", totalOption);
			JoinCarView join = new JoinCarView(list.get(i).getReserveSeq(),list.get(i).getNo(),car.getImg(),car.getName(),list.get(i).getRday(),list.get(i).getDday(),total,list.get(i).getQty(),list.get(i).getUserin(),list.get(i).getUsewifi(),list.get(i).getUseseat(),list.get(i).getUsenavi());
			carResevelist.add(join);
		}
		request.setAttribute("list", carResevelist);
		return "rentcar/userReserveList";
	}

}
