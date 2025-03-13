package kr.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.dao.UserDAO;
import kr.basic.frontController.Controller;


public class LoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		if (id == null || id.trim().isEmpty()) {
			return "user/login";
		}
		String pw = request.getParameter("pw");

		String ctx = request.getContextPath();
		
		if(id.equals("admin") && pw.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("log", -1);
			session.setAttribute("loginId", "admin");
			return "redirect:/main.do";
		}
		System.out.println(id);
		if (!UserDAO.getInstance().checkLogin(id, pw)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 실패'); history.back();</script>");
			writer.close();
			return null;
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("log", UserDAO.getInstance().getUserNo(id));
			session.setAttribute("loginId", id);
			
			return "redirect:/main.do";
		}
		

	}
}
