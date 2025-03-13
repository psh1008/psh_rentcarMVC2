package kr.basic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.dao.RentCarDAO;
import kr.basic.dao.ReservationDAO;
import kr.basic.frontController.Controller;
import kr.basic.vo.JoinCarView;
import kr.basic.vo.RentCar;

public class ReservationListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

			int log = (int) request.getSession().getAttribute("log");
			
			List<JoinCarView> list;
			
			if(log == -1) {
				list = ReservationDAO.getInstance().getAllReservations();
			}else {
				list = ReservationDAO.getInstance().getReservationList(log);
			}
			
			if(list == null|| list.size() == 0) {
				request.setAttribute("reservList", null);
			}else {
				request.setAttribute("reservList", list);
			}
		
			return "user/reservationList";
	}

}