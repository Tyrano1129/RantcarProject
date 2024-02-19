package com.basic.rentcar.controller.rentcar;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.frontController.Controller;

public class SelectCarOptionController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	String formatedNow = now.format(formatter);
    	request.setAttribute("today", formatedNow);
    	
    	String img = request.getParameter("img");
    	int qty = Integer.parseInt(request.getParameter("qty"));
    	int no = Integer.parseInt(request.getParameter("no"));
    	
    	request.setAttribute("img", img);
    	request.setAttribute("qty", qty);
    	request.setAttribute("no", no);
    	
		return "rentcar/carOption";
	}
}
