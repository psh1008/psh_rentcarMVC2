package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.dao.RentCarDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.RentCar;

public class RegisterCarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		
		RentCar car = RentCarDAO.getInstance().getOneCarInfo(num);
		
		request.setAttribute("car", car);
		request.setAttribute("num", num);
		request.setAttribute("qty", qty);


		return "user/registerCar";
	}

}