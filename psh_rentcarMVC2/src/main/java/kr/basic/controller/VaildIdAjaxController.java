package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.dao.UserDAO;
import kr.basic.frontController.Controller;

public class VaildIdAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id=request.getParameter("id"); // { "id" : id  }
		String passData = UserDAO.getInstance().isValidId(id)? "notValid" : "valid";
	
		response.getWriter().print(passData); // "notValid" : "valid";
		
		return null;
	}

}
