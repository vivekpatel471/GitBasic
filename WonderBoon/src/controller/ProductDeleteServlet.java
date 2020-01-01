package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;

/**
 * Servlet implementation class ProductDeleteServlet
 */
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
		String product_id = request.getParameter("product_id");

		if(new AdminDao().ProductDelete(product_id))
		{
			response.sendRedirect("ProductListServlet");
		}
		else
		{
			response.sendRedirect("ProductListServlet");
		}
		
		

	
	
	
	
	}

}
