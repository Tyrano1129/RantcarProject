package com.basic.rentcar.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basic.rentcar.dao.RentCarDAO;
import com.basic.rentcar.frontController.Controller;

import combasic.rentcar.vo.Rentcar;

public class MainController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ArrayList<Rentcar> list = null;
		list = RentCarDAO.getInstance().getCarList();
		request.setAttribute("list", list);
		return "main";
	}

}
