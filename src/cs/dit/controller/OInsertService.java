package cs.dit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.LoginDao;
import cs.dit.dto.LoginDto;

public class OInsertService implements OrderService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String p_name = request.getParameter("p_name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		LoginDto dto = new LoginDto(0, p_name, quantity, price); 
		LoginDao dao = new LoginDao();
		
		dao.insert(dto);
	}

}
