package com.basic.rentcar.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.rentcar.CarInfoController;
import com.basic.rentcar.controller.rentcar.CarListController;
import com.basic.rentcar.controller.rentcar.DeleteResController;
import com.basic.rentcar.controller.rentcar.InsertCarController;
import com.basic.rentcar.controller.rentcar.RegisterCarController;
import com.basic.rentcar.controller.rentcar.ReservateCarController;
import com.basic.rentcar.controller.rentcar.SelectCarOptionController;
import com.basic.rentcar.controller.rentcar.UploadCarImgController;
import com.basic.rentcar.controller.rentcar.UserReserveListController;
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
		mappings.put("/carList.do",new CarListController());
		mappings.put("/rentCartInfo.do", new CarInfoController());
		mappings.put("/carOption.do", new SelectCarOptionController());
		mappings.put("/reserveCarView.do", new ReservateCarController());
		mappings.put("/userReserveList.do", new UserReserveListController());
		mappings.put("/deleteres.do", new DeleteResController());
		mappings.put("/imgupload.do", new UploadCarImgController());
		mappings.put("/carInsert.do", new InsertCarController());
		mappings.put("/registerCar.do", new RegisterCarController());
	}
	
	public Controller getController(String url) {
		return mappings.get(url);
	}
}
