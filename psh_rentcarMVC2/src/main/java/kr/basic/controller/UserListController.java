package kr.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.dao.RentCarDAO;
import kr.basic.dao.ReservationDAO;
import kr.basic.dao.UserDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.JoinCarView;
import kr.basic.vo.RentCar;
import kr.basic.vo.User;

public class UserListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			ArrayList<User> list = UserDAO.getInstance().userList();
			request.setAttribute("list", list);
		
			return "user/userList";
	}

}