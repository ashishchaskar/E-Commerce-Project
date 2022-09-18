package com.microsoft.amazon;

import java.sql.*;
import java.util.*;


public class AddToCart extends ConnectionDetails implements Ecommerce{


	@Override
	public void getToCart() {
		
		
		try {
			
			Connection connection = getConnectionDetails();
			
			//Step-3 Prepare Statement
            PreparedStatement prepareStatement = connection.prepareStatement("Select * from products_table");
		    
            //step-4 Execute Query
		    ResultSet rs = prepareStatement.executeQuery();
		    
		    System.out.println("Available Products Are : = >");
		    
		    while(rs.next()) {
		    	
		    	System.out.println(rs.getString("Product_id"));
		    	System.out.println(rs.getString("Name"));
		    	
		    }
		    
		    connection.close();
		    prepareStatement.close();
		
		} catch (Exception e) {
			
		  System.out.println(e);
		}
		
	}
      
	   public static void main(String[] args) {
		
		   AddToCart addToCart=new AddToCart();
		   
		   addToCart.getToCart();
		   
		   
	}

	@Override
	public void getProductDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerUser() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
