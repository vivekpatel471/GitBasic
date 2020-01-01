package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String userName = "root";
    private static String password = "root";
    private static String driverClass = "com.mysql.jdbc.Driver";
    private static String connectionUrl = "jdbc:mysql://localhost:3306/project";
    
    public static Connection getConnection(){
		
    	Connection conn = null;
    	System.out.println("Git hub Project");
    	try {
			Class.forName(driverClass);
			
			conn = DriverManager.getConnection(connectionUrl, userName, password);
			
			if(conn != null)
			{
				System.out.println("Connection Established....");
			}
			else
			{
				System.out.println("Connection failed to establish....");
			}
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	return conn;
    	
    	
    	
    	
    	
    	
    }

}
