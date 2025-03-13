package kr.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.dao.RentCarDAO;
import kr.basic.dao.ReservationDAO;
import kr.basic.dao.UserDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.JoinCarView;
import kr.basic.vo.RentCar;
import kr.basic.vo.User;

public class UserInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

			int log = (int) request.getSession().getAttribute("log");
			
			User u = null;
			u = UserDAO.getInstance().getUserInfo(log);
			
			if(u != null) {
				request.setAttribute("user", u);
			}else {
				System.out.println("null 에러");
			}
			
			return "user/userInfo";
	}

}