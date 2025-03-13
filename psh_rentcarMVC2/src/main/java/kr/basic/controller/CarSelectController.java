package kr.basic.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.dao.RentCarDAO;
import kr.basic.dao.ReservationDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.RentCar;

public class CarSelectController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String dday = request.getParameter("dday");
		String rday = request.getParameter("rday");
		String usein = request.getParameter("usein");
		String usewifi = request.getParameter("usewifi");
		String usenavi = request.getParameter("usenavi");
		String useseat = request.getParameter("useseat");
		HttpSession session = request.getSession();
		String id =	(String) session.getAttribute("loginId");
		String qty =  request.getParameter("qty");
		String img = request.getParameter("img");
		int num = Integer.parseInt(request.getParameter("num"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		String name = request.getParameter("name");
		int totalRs = Integer.parseInt(qty) * Integer.parseInt(dday) * price;
		int totalOp= Integer.parseInt(qty) * ((Integer.parseInt(usein)*
				Integer.parseInt(usewifi) * Integer.parseInt(usenavi) * Integer.parseInt(useseat))*10000);
		int totalPrice= totalRs + totalOp;
		session.setAttribute("img", img);
		session.setAttribute("totalRs", totalRs);
		session.setAttribute("totalOp", totalOp);
		session.setAttribute("totalPrice", totalPrice);
		
		
		int cnt;
		
		cnt = ReservationDAO.getInstance().addCarReservation(num,id,qty,dday,rday,usein,usewifi,usenavi,useseat);
		
		if(cnt != -1) {
			System.out.println("예약하기 성공");
		}else {
			System.out.println("예약하기 실패");
			
		}
		
		return "user/carReservationResult";
	}
}

