package com.basic.rentcar.controller.rentcar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;

import combasic.rentcar.vo.Rentcar;

public class CarInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("num"));
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		Rentcar car = RentCarDAO.getInstance().getCarInfo(num);
		
		System.out.println(car);
		request.setAttribute("car", car);
		
		return "rentcar/rentcarInfo";
	}

}
