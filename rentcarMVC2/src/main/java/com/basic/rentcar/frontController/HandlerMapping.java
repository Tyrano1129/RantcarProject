package com.basic.rentcar.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.user.*;

public class HandlerMapping {
	private HashMap<String,Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String,Controller>();
		
		mappings.put("/main.do",new MainController());
		mappings.put("/loginUser.do",new LoginCheckController());
		mappings.put("/logoutUser.do", new LoginOutController());
		mappings.put("/joinUser.do",new JoinUserController());
		mappings.put("/validIdCheck.do", new ValidateIdController());
		mappings.put("/userInfo.do", new UserInfoController());
		mappings.put("/vaildPwCheck.do", new ValidatePwController());
		mappings.put("/userDelete.do", new DeleteUserController());
		mappings.put("/userUpdate.do", new UpdateuserController());
	}
	
	public Controller getController(String url) {
		return mappings.get(url);
	}
}
