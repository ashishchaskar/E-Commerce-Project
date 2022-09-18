package com.microsoft.amazon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SortedProductData extends ConnectionDetails {
	
	public void getSortedProductList() {
		
		   try {
			   
		
	 Connection connection = getConnectionDetails();
		         
		     //Prepare Statement
		   
     PreparedStatement prepareStatement = connection.prepareStatement(" Select Product_id,Name "
				                    + "from products_table order by Product_id ");   
		    
            //Execute statement
     
     ResultSet rs = prepareStatement.executeQuery();
	
     System.out.println("Sorted product list");
	 while(rs.next()) {	
		 
		 System.out.println(rs.getString(1));
		 System.out.println(rs.getString(2));
		 
		 
		 }
     
		   }catch(Exception e) { 
			   
			   System.out.println(e);
			   
			}
		
	}
	
	public static void main(String[] args) {
		
		SortedProductData s= new SortedProductData();
		s.getSortedProductList();
	}	
		
}

