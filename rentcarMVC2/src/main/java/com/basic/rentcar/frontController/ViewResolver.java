package com.basic.rentcar.frontController;

public class ViewResolver {
	public static String ViewResolver(String nextPage) {
		return "/WEB-INF/"+nextPage+".jsp";
	}
}
