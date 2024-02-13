package com.basic.rentcar.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class RentcarFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String url = request.getRequestURI();
		String ctx = request.getContextPath();
		
		System.out.println("url = " + url);
		System.out.println("ctx = " + ctx);
		String command = url.substring(ctx.length());
		
		Controller controller = null;
		String nextPage = null;		
		
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(request, response);
		
		if(nextPage != null) {
			if(nextPage.indexOf("re:") != -1) {
				response.sendRedirect(nextPage.split(":")[1]);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.ViewResolver(nextPage));
				rd.forward(request, response);
			}
		}
		
		
	}
}
