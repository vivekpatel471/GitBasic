package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		String userName = request.getParameter("txtUserName");
		String password = request.getParameter("txtPassword");
		
		
		HttpSession session = request.getSession();
		if(AdminDao.login(userName, password)){  
            
			session.setAttribute("userName",userName);
			
			response.sendRedirect("Admin/index.jsp");
			
		}
		
		else{
			
		//	PrintWriter out = response.getWriter();
			
			response.sendRedirect("Admin/Login.jsp");
	 		session.setAttribute("getAlert", "Yes");
//			RequestDispatcher rd = request.getRequestDispatcher("/Admin/Login.jsp");
//			rd.forward(request, response);
		}
		
		
	
	}

	
	
}


