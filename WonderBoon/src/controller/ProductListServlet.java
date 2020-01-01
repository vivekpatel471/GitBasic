package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ProductBean;
import dao.AdminDao;

/**
 * Servlet implementation class ProductListServlet
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
List<ProductBean> ListOfProduct = new AdminDao().productList();
		
		if(ListOfProduct != null)
		{
			request.setAttribute("ListOfProduct", ListOfProduct);
			request.getRequestDispatcher("ManageProduct.jsp").forward(request, response);
		}
		else
		{
			
		}

	
	
	}

}
