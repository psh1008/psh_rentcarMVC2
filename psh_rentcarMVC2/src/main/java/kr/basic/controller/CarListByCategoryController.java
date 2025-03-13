package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.dao.RentCarDAO;
import kr.basic.dao.UserDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.RentCar;
import kr.basic.vo.User;

public class CarListByCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int num = Integer.parseInt(request.getParameter("category"));
		System.out.println("num = "+num);
		String categoryName = null;
		if(num == 1) {
			categoryName = "소형";
		}else if(num == 2) {
			categoryName = "중형";
		}else {
			categoryName = "대형";
		}
		
		ArrayList<RentCar> list = null;
		list = RentCarDAO.getInstance().CarListByCategory(num);
		
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("categoryName", categoryName);
			return "user/carListByCategory";
		}else {
			System.out.println("카테고리 오류");
		}
		
		return "user/carListByCategory";
		
	}

}