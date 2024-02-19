package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;

import combasic.rentcar.vo.Rentcar;

public class CarListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ArrayList<Rentcar> list = null;
		if(request.getParameter("category") == null) {
			list = RentCarDAO.getInstance().getCarList();
		}else if(request.getParameter("category") != null) {
			// 카테고리 맞는 종류만 리스트담기
			System.out.println(request.getParameter("category"));
			list = RentCarDAO.getInstance().carListCategroy(Integer.parseInt(request.getParameter("category")));
			String categroy = Integer.parseInt(request.getParameter("category")) == 1? "소형" : 
				Integer.parseInt(request.getParameter("category")) == 2? "중형": 
				Integer.parseInt(request.getParameter("category")) == 3? "대형": "신형";
			System.out.println(categroy);
			request.setAttribute("category",categroy);
		}
		
		
		request.setAttribute("list", list);
		
		return "rentcar/rentCarList";
	}

}
