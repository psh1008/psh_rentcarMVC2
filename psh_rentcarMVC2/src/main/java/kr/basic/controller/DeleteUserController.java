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
import kr.basic.util.JSFunction;
import kr.basic.vo.JoinCarView;
import kr.basic.vo.RentCar;

public class DeleteUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			Integer num = Integer.parseInt(request.getParameter("num"));
			System.out.println("usernum = " + num);
			
			int cnt = UserDAO.getInstance().deleteUser(num);
			HttpSession session = request.getSession();
			String ctx = request.getContextPath();
			System.out.println("ctx = "+ctx);
			Object log =  session.getAttribute("log");
			if(cnt != 0) {

				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				JSFunction.alertLocation("회원삭제 완료","userList.do",writer,ctx,log);
				
				writer.close();
			}
			
		
			return null;
	}

}