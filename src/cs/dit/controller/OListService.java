package cs.dit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs.dit.dao.LoginDao;
import cs.dit.dto.LoginDto;

public class OListService implements OrderService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		LoginDao dao = new LoginDao();
		ArrayList<LoginDto> dtos = dao.list();
		request.setAttribute("dtos", dtos);
	}
}
