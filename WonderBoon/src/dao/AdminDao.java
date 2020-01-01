package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CategoryBean;
import bean.CustomerBean;
import bean.ProductBean;

import util.DBConnection;

public class AdminDao {
	
	Connection conn;
	PreparedStatement pstmt;
	private ResultSet rs = null;
	
	
	//ADMIN LOGIN DAO
public static boolean login(String userName, String password){
	
	Connection conn;
	PreparedStatement pstmt;

		ResultSet rs = null;
		
		conn = DBConnection.getConnection();
		boolean status = false;
		
		if(conn!=null){
			
			String selectSql = "select * from admin where userName = ? and password = ?";
			
			System.out.println(userName +" "+password);
			
			try {
				pstmt = conn.prepareStatement(selectSql);
			
			pstmt.setString(1,userName);
			pstmt.setString(2,password);
			
			rs = pstmt.executeQuery();
			
			status=rs.next();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return status;
	}




//ADMIN PANEL CUSTOMER LIST
public List<CustomerBean> list()
{

List<CustomerBean> ListOfCustomer = new ArrayList<CustomerBean>();
conn = DBConnection.getConnection();
if(conn !=null)
{
	String selectSql = "Select * from customer";
	
	try {
		pstmt = conn.prepareStatement(selectSql);
		rs = pstmt.executeQuery();
		
		CustomerBean user = null;
		while(rs.next()){
			System.out.println("Admin Dao......");
			user = new CustomerBean();
			user.setCustomer_id(rs.getInt("customer_id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setDob(rs.getString("dob"));
			user.setAddress(rs.getString("address"));
			
			
			ListOfCustomer.add(user);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
return ListOfCustomer;
}








//CUSTOMER DELETE DAO (ADMIN PANEL)
public boolean delete(String customer_id){
	
	
	boolean result=false;
	conn = DBConnection.getConnection();
	if(conn!=null){
		
		String DeleteSQl = "delete from customer where customer_id=?";
		
		
		try {
			pstmt = conn.prepareStatement(DeleteSQl);
			pstmt.setString(1, customer_id);
			
			int rowsaffected = pstmt.executeUpdate();
			if(rowsaffected>0){
				
				result=true;
				System.out.println(rowsaffected + " Row(s) deleted......");

			} else {
				System.out.println(rowsaffected + " Row(s) deleted......");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return false;
}



//PRODUCT LIST DAO (ADMIN PANEL)
public List<ProductBean> productList()
{

List<ProductBean> ListOfProduct = new ArrayList<ProductBean>();
conn = DBConnection.getConnection();
if(conn !=null)
{
	String selectSql = "Select * from product";
	
	try {
		pstmt = conn.prepareStatement(selectSql);
		rs = pstmt.executeQuery();
		
		ProductBean product = null;
		while(rs.next()){
			product = new ProductBean();
			product.setProduct_id(rs.getInt("product_id"));
			product.setP_name(rs.getString("p_name"));
			product.setP_description(rs.getString("p_description"));
			product.setPrice(rs.getFloat("price"));
			product.setQuantity(rs.getInt("quantity"));
			product.setP_image(rs.getString("p_image"));
			product.setCategory_id(rs.getInt("category_id"));
			
			
			ListOfProduct.add(product);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
return ListOfProduct;
}




//PRODUCT DELETE DAO (ADMIN PANEL)
public boolean ProductDelete(String product_id){
	
	
	boolean result=false;
	conn = DBConnection.getConnection();
	if(conn!=null){
		
		String DeleteSQl = "delete from product where product_id=?";
		
		
		try {
			pstmt = conn.prepareStatement(DeleteSQl);
			pstmt.setString(1, product_id);
			
			int rowsaffected = pstmt.executeUpdate();
			if(rowsaffected>0){
				
				result=true;
				System.out.println(rowsaffected + " Row(s) deleted......");

			} else {
				System.out.println(rowsaffected + " Row(s) deleted......");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	return result;
	}




//GET PRODUCT BY PRIMARY KEY
public ProductBean getProductByPk(String product_id){
	
	conn = DBConnection.getConnection();
	ProductBean user = new ProductBean();
	if(conn != null){
		
		String selectSql = "Select * from product where product_id = ? ";
		
		try {
			pstmt = conn.prepareStatement(selectSql);
			
			pstmt.setString(1, product_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				user = new ProductBean();
				
				user.setProduct_id(rs.getInt("product_id"));
				user.setP_name(rs.getString("p_name"));
				user.setP_description(rs.getString("p_description"));
				user.setPrice(rs.getFloat("price"));
				user.setQuantity(rs.getInt("quantity"));
				user.setP_image(rs.getString("p_image"));
				user.setCategory_id(rs.getInt("category_id"));
				
				
				

			}				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return user;
}



//PRODUCT UPDATE DAO (ADMIN PANEL)
public boolean ProductUpdate(ProductBean user){
	
	boolean result = false;
	conn = DBConnection.getConnection();
	if(conn != null)
	{
		String updateSql = "update product set p_name= ?, p_description = ?, price = ?, quantity = ?, p_image = ?, category_id = ? where product_id = ?";
		
		try {
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setString(1, user.getP_name());
			pstmt.setString(2, user.getP_description());
			pstmt.setFloat(3, user.getPrice());
			pstmt.setInt(4, user.getQuantity());
			pstmt.setString(5,user.getP_image());
			pstmt.setInt(6, user.getCategory_id());
			pstmt.setInt(7, user.getProduct_id());
			
			
			int rowsaffected = pstmt.executeUpdate();
					if(rowsaffected > 0)
					{
						result = true;
						System.out.println(rowsaffected + " Rows updated");
					}
					else
					{
						System.out.println(rowsaffected + " Rows updated");
					}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	return result;
	
	
}




//PRODUCT INSERT DAO (ADMIN PANEL)
public boolean ProductInsert(ProductBean userBean)
{
	Boolean flag = false;
	conn = DBConnection.getConnection();
	
	if(conn!=null)
	{
		
	try {
		
		String insertSql1 = "insert into product (p_name,p_description, price, quantity, p_image, category_id)values(?,?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(insertSql1);
		
		pstmt.setString(1, userBean.getP_name());
		pstmt.setString(2, userBean.getP_description());
		pstmt.setFloat(3, userBean.getPrice());
		pstmt.setInt(4, userBean.getQuantity());
		pstmt.setString(5, userBean.getP_image());
		pstmt.setInt(6, userBean.getCategory_id());
		
		
		int res1 = pstmt.executeUpdate();
		
		
		if(res1>0)
		{
			flag = true;
			System.out.println("rows inserted");
		}
		else
		{
			System.out.println("rows not inserted..");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	return flag;
	
}



//CATEGORY DAO --> SHOW LIST

public List<CategoryBean> categoryList()
{
List<CategoryBean> listOfCategory = new ArrayList<CategoryBean>();

conn =DBConnection.getConnection();
if(conn !=null)
{
	String selectSQL = "select * from category ";
	try {
		pstmt = conn.prepareStatement(selectSQL);
		
		rs = pstmt.executeQuery();

		CategoryBean category = null;
		while(rs.next()){
			category = new CategoryBean();
		
			category.setCategory_id(rs.getInt("category_id"));
			category.setName(rs.getString("name"));
		
			listOfCategory.add(category);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
System.out.println(listOfCategory);
return listOfCategory;


}







}
