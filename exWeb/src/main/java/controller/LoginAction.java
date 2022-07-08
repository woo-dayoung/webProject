package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import user.UserDTO;

/**
 * Servlet implementation class LoginAction
 */
//@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doGet() 메소드 : request method - GET 
		UserDAO dao = UserDAO.getInstance();
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		UserDTO user = new UserDTO(id,pw);
//		String url ="_05.board.jsp";
		String url ="./board";
		
		// 1.리다이렉트 처리
		request.getRequestDispatcher(url).forward(request, response);
		//디스패처를 써서 주소가 그대로이고 컨텐츠만 바뀜
		//세션 활용
		HttpSession session = request.getSession();
		session.setAttribute("log", id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
		//doPOST() 메소드 : request method - GET 
	}

}
