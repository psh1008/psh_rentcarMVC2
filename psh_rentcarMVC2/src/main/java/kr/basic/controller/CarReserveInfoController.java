package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.dao.RentCarDAO;
import kr.basic.frontController.Controller;
import kr.basic.util.MybatisConfig;
import kr.basic.vo.RentCar;

public class CarReserveInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		
		RentCar car = RentCarDAO.getInstance().getOneCarInfo(num);
		request.setAttribute("car", car);

		return "user/carReserveInfo";
	}

}