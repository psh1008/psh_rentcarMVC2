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
import kr.basic.frontController.Controller;
import kr.basic.util.JSFunction;
import kr.basic.vo.JoinCarView;
import kr.basic.vo.RentCar;

public class DeleteReservationController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			Integer reserveSeq = Integer.parseInt(request.getParameter("reserveSeq"));
			System.out.println("reserveSeq = " + reserveSeq);
			
			int cnt = ReservationDAO.getInstance().deleteReservation(reserveSeq);
			HttpSession session = request.getSession();
			String ctx = request.getContextPath();
			System.out.println("ctx = "+ctx);
			int log = (int) session.getAttribute("log");
			System.out.println("log = " + log);
			if(cnt != 0) {

				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				JSFunction.alertLocation("예약취소 성공","reservationList.do",writer,ctx,log);
				
				writer.close();
			}
			
		
			return null;
	}

}