package kr.basic.controller;

import java.io.IOException;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.dao.UserDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.User;

public class JoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		String name = request.getParameter("name");
		if (name == null || name.trim().isEmpty()) {
			return "user/join";
		}
		String id = request.getParameter("id");
		String pwd = request.getParameter("pw");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		User u = new User(name,id,pwd,email,phone);
    
		String ctx = request.getContextPath();
		int cnt = UserDAO.getInstance().userJoin(u);
		System.out.println(cnt);
		if (cnt > 0) {
			return "redirect:/main.do";
		} else {
			throw new ServletException("not insert");
		}
		
		
	}

}