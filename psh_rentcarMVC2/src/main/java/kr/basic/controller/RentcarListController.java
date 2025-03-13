package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.dao.RentCarDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.RentCar;

public class RentcarListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<RentCar> list = RentCarDAO.getInstance().rentcarList();
		
		request.setAttribute("list", list);

		
		return "user/rentcarList";
	}

}