package kr.basic.frontController;

import java.util.HashMap;

import kr.basic.controller.AddRentcarController;
import kr.basic.controller.CarListByCategoryController;
import kr.basic.controller.CarReserveInfoController;
import kr.basic.controller.CarSelectController;
import kr.basic.controller.DeleteReservationController;
import kr.basic.controller.DeleteUserController;
import kr.basic.controller.JoinController;
import kr.basic.controller.LoginController;
import kr.basic.controller.LogoutController;
import kr.basic.controller.MainController;
import kr.basic.controller.RegisterCarController;
import kr.basic.controller.RentcarListController;
import kr.basic.controller.ReservationListController;
import kr.basic.controller.UpdateUserController;
import kr.basic.controller.UserInfoController;
import kr.basic.controller.UserListController;
import kr.basic.controller.VaildIdAjaxController;


public class HandlerMapping {
  private HashMap<String, Controller> mappings;
  public HandlerMapping() { 
	  mappings=new HashMap<String, Controller>();
	  
	  mappings.put("/main.do", new MainController());
	  mappings.put("/join.do", new JoinController());
	  mappings.put("/login.do", new LoginController());
	  mappings.put("/logout.do", new LogoutController());
	  mappings.put("/rentcarList.do", new RentcarListController());
	  mappings.put("/vaildIdAjax.do", new VaildIdAjaxController());
	  mappings.put("/carReserveInfo.do", new CarReserveInfoController());
	  mappings.put("/registerCar.do", new RegisterCarController());
	  mappings.put("/carSelect.do", new CarSelectController());
	  mappings.put("/reservationList.do", new ReservationListController());
	  mappings.put("/deleteReservation.do", new DeleteReservationController());
	  mappings.put("/userList.do", new UserListController());
	  mappings.put("/deleteUser.do", new DeleteUserController());
	  mappings.put("/addRentcar.do", new AddRentcarController());
	  mappings.put("/carListByCategory.do", new CarListByCategoryController());
	  mappings.put("/updateUser.do", new UpdateUserController());
	  mappings.put("/userInfo.do", new UserInfoController());
	  

  }
  public Controller getController(String key) { 
	  return mappings.get(key);
  }
}