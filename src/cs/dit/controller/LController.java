package cs.dit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("*.do")
public class LController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); 
		String uri = request.getRequestURI(); //브라우저 주소 받아옴
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do")); //주소창에 마지막/와 .do사이에 값을 받아서 com에 저장
		String viewPage = null;
		
		OrderService service = null;
		
		switch (com.trim()){
		case "list":
			service = new OListService();
			service.execute(request, response);//컨트롤러가 OListService로 갔다가 뷰(리스트)로 다시 감
			viewPage = "/WEB-INF/view/list.jsp";
			break;
		case "insertForm":
			service = new OListService();
			service.execute(request, response);//OListService로 갔다가 뷰(insertForm)로 다시 감
			viewPage = "/WEB-INF/view/insertForm.jsp";
			break;
		case "insert":
			service = new OInsertService();
			service.execute(request, response);//OInsertService로 갔다가 뷰(리스트)로 다시 감
			viewPage = "/WEB-INF/view/list.do";
			break;
		case "update":
			viewPage = "WEB-INF/view/insertForm.jsp";
			break;
		case "updateForm":
			service = new OViewService();
			service.execute(request, response);
			viewPage = "WEB-INF/view/updateForm.jsp";
			break;	
		case "updateService":
			service = new OUpdateService();
			service.execute(request, response);
			viewPage = "WEB-INF/view/list.do";
			break;	
		case "delete":
			service = new ODeleteService();
			service.execute(request, response);
			viewPage = "WEB-INF/view/list.do";
			break;	
		case "index":
			viewPage = "/WEB-INF/view/index.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage); //컨트롤러가 뷰로 전달할 수 있게하는 메소드
		rd.forward(request, response); //rd로 request와 response 를 전달
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

}