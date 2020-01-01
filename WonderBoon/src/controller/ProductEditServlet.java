package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProductBean;
import dao.AdminDao;

/**
 * Servlet implementation class ProductEditServlet
 */
public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
	
		
		String product_id = request.getParameter("product_id");
		System.out.println(product_id);
		ProductBean user = new AdminDao().getProductByPk(product_id);
	
		if(user != null)
		{
			request.setAttribute("user", user);
			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
			
		}
	}

}
