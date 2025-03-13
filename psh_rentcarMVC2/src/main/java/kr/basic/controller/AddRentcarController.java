package kr.basic.controller;

import java.io.IOException;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.dao.RentCarDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.RentCar;

public class AddRentcarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		if (name == null || name.trim().isEmpty()) {
			return "user/addRentcar";
		}
		int category = Integer.parseInt(request.getParameter("category"));
		int price = Integer.parseInt(request.getParameter("price"));
		int usepeople = Integer.parseInt(request.getParameter("usepeople"));
		int total_qty = Integer.parseInt(request.getParameter("total_qty"));
		String company = request.getParameter("company");
		String img = request.getParameter("img");
		String info = request.getParameter("info");
		
		
		String ctx = request.getContextPath();
		int cnt = RentCarDAO.getInstance().addRentcar(name, category, price, usepeople, total_qty, company, img, info);
		if(cnt != 0) {
			
			return "redirect:/main.do";
		}else {
			System.out.println("등록 에러");
		}
		return null;
	}

}