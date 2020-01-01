package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerBean;
import dao.AdminDao;

/**
 * Servlet implementation class CustomerListServlet
 */
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
List<CustomerBean> ListOfCustomer = new AdminDao().list();

	
		
		if(ListOfCustomer != null)
		{
			System.out.println("Customer List Servlet.....");
			request.setAttribute("ListOfCustomer", ListOfCustomer);
			request.getRequestDispatcher("ManageCustomer.jsp").forward(request, response);
		}
		else
		{
			
		}
		

	
	
	}

}
