package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.ProductBean;
import dao.AdminDao;

/**
 * Servlet implementation class ProductInsertServlet
 */
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String filePath;

	public void init() {
		filePath = getServletContext().getInitParameter("file-upload");
		System.out.println(filePath);
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * String p_name = request.getParameter("txtProductName"); String p_desc
		 * = request.getParameter("txtDescription"); float price =
		 * Float.parseFloat(request.getParameter("txtPrice")); int quantity =
		 * Integer.parseInt(request.getParameter("txtQuantity")); String p_image
		 * = request.getParameter("txtImage"); int category_id =
		 * Integer.parseInt(request.getParameter("txtCategory_id"));
		 * 
		 * 
		 * 
		 * 
		 * ProductBean userBean = new ProductBean();
		 * 
		 * userBean.setP_name(p_name); userBean.setP_description(p_desc);
		 * userBean.setPrice(price); userBean.setQuantity(quantity);
		 * userBean.setP_image(p_image); userBean.setCategory_id(category_id);
		 */

		ProductBean userBean = new ProductBean();

		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());

		System.out.println(sf);
		try {
			List<FileItem> listFile;

			listFile = sf.parseRequest(request);

			if (listFile != null) {

				for (FileItem item : listFile) {
					try {
						if (item.getFieldName().equals("txtProductName")) {

							String p_name = item.getString();
							System.out.println(p_name);
							userBean.setP_name(p_name);
						}
						if (item.getFieldName().equals("txtDescription")) {
							String p_description = item.getString();
							userBean.setP_description(p_description);

						}

						if (item.getFieldName().equals("txtPrice")) {
							float price1 = Float.parseFloat(item.getString());
							// float price=
							// Float.parseFloat(item.getFieldName());
							System.out.println(price1);

							userBean.setPrice(price1);

						}
						// int q = Integer.parseInt("txt");
						if (item.getFieldName().equals("txtQuantity")) {
							int quantity = Integer.parseInt(item.getString());
							System.out.println(quantity);

							userBean.setQuantity(quantity);

						}
						if (item.getName() != null) {
							item.write(new File(filePath + "\\"
									+ item.getName()));
							String path = filePath.substring(
									filePath.lastIndexOf('\\'),
									filePath.length())
									+ "\\" + item.getName();
							path = path.substring(1, path.length());
							System.out.println("path --> " + path);
							userBean.setP_image(path);

							// AdminDao AdminDao = new AdminDao();
							// AdminDao.ProductInsert(userBean);

							System.out.println("file uploaded");

						}
						if (item.getFieldName().equals("txtCategory_id")) {
							int category_id = Integer
									.parseInt(item.getString());

							userBean.setCategory_id(category_id);

						}

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("not uploaded");
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (new AdminDao().ProductInsert(userBean)) {

			if (userBean.getCategory_id() == 1) {
				System.out.println("inside dao");
				response.sendRedirect("ProductListServlet");
			} else {
				System.out.println("inside dao");
				response.sendError(404);
			}

			// response.sendRedirect("ProductListServlet");
		} else {
			response.sendRedirect("Admin/ManageProduct.jsp");
		}

	}

}
