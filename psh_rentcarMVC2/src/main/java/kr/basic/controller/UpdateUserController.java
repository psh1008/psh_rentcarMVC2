package kr.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.dao.RentCarDAO;
import kr.basic.dao.UserDAO;
import kr.basic.frontController.Controller;
import kr.basic.util.JSFunction;
import kr.basic.vo.RentCar;

public class UpdateUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer num = Integer.parseInt(request.getParameter("num"));
		System.out.println("usernum = " + num);
		String email = request.getParameter("email");
		
		if(email == null) {
			System.out.println("123");
			return "user/updateUser";
		}
		String phone = request.getParameter("phone");
		
		System.out.println("email = " + email);
		System.out.println("phone = " + phone);
		
		int cnt = UserDAO.getInstance().updateUser(num,email,phone);
	
		if(cnt !=0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정실패");
		}
		
		return "user/userList";
		
		
	}

}