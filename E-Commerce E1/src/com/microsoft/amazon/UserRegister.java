package com.microsoft.amazon;

import java.sql.*;
import java.util.*;

public class UserRegister extends ConnectionDetails implements Ecommerce {

	Scanner scanner=new Scanner(System.in);
	String username,mobile_number,email_id,user_password=null;
	
	
	public void registerUser(String username,String mobile_number,String email_id, String user_password  ) {
		
		  try {
		      
			  Connection connection = getConnectionDetails();
		      
    //Step - 3 : Prepare Statement
		      
	PreparedStatement prepareStatement = connection.prepareStatement("insert into registered_users_list "+
		                    "(username,mobile_number,email_id,user_password)values(?,?,?,?)");
	
	         prepareStatement.setString(1, username);
	         prepareStatement.setString(2, mobile_number);
	         prepareStatement.setString(3, email_id);
	         prepareStatement.setString(4, user_password);
		      
	//Step -4: Execute Prepare statement
	
	                    int k = prepareStatement.executeUpdate();
	                    
	         System.out.println("Data inserted successfully " + k);           
	             
	                   
		        }catch(Exception e) {
		    	 
		    	 System.out.println(e);
		        
		    }
	
	}
	
	public void getUserInputForUserRegister() {
		
		System.out.println("Enter Details Registration of Users");
		
		for(int i=0; i<3; i++) {
		
			System.out.println("Enter Username");
			username = scanner.nextLine();
			
			System.out.println("Enter Mobile number");
			mobile_number = scanner.nextLine();
			
			System.out.println("Enter email id");
			email_id=scanner.nextLine();
		
			System.out.println("Enter Password");
			user_password=scanner.nextLine();
			

			registerUser(username,mobile_number,email_id,user_password);
			
		}
	 }
	
	public static void main(String[] args) {
		
		UserRegister register=new UserRegister();
		
		register.getUserInputForUserRegister();
		
		
	}

	@Override
	public void getProductDetails() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getToCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerUser() {
		// TODO Auto-generated method stub
		
	}
	
	
}

