package com.microsoft.amazon;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDetails  {
	

	public Connection getConnectionDetails() {
		
		Connection con=null;
		
		try {
			
			//Step - 1 Load the Driver class 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//Step-2 Establish connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Ac23111997@1");
			
		   } catch (Exception e) {
			
			System.out.println(e);
		}
		
	     return con;
	}

}

