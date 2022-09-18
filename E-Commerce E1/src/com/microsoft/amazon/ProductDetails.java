package com.microsoft.amazon;

import java.sql.*;
import java.util.*;


public class ProductDetails extends ConnectionDetails implements Ecommerce{
	
	Scanner scanner=new Scanner(System.in);
	
	//Declare DB Connection
	Connection connection=null;
	PreparedStatement prepareStatement =null;
	
	//Declare and initialize for Products_Table
	String name,price,quantity,description=null;
    

	//Hierarchial order 
  @Override
	public  void getProductDetails() {
		
		List<String> electronics=new ArrayList<String>();
		
		electronics.add("Iphone");
		electronics.add("washing machine");
		
		List<String> dailyEssentials=new LinkedList<String>();
		
		dailyEssentials.add("Organic Wheat");
		dailyEssentials.add("Edible Oil");
		
		List<String> beauty=new LinkedList<String>();
		beauty.add("soap");
 		beauty.add("Facewash");
 		
 		List<String> fashion=new LinkedList<String>();
 		fashion.add("T shirt");
 		fashion.add("saree");
 		
 		List<String> furniture=new LinkedList<String>();
 		furniture.add("Sofa");
 		furniture.add("Study table");
		
		Map<String,List<String>> hmproductCategory=new HashMap<String,List<String>>();
		
		hmproductCategory.put("Electronics", electronics);
		hmproductCategory.put("Daily Essentials", dailyEssentials);
		hmproductCategory.put("Beauty", beauty);
		hmproductCategory.put("Fashion", fashion);
		hmproductCategory.put("Furniture", furniture);
		
		Map<String,Map<String,List<String> > > hmcompany=new HashMap<String,Map<String,List<String> > >();
		
		 hmcompany.put("Amazon", hmproductCategory);
		 
		         Set<String> set = hmcompany.keySet();
		         
		             for(String str : set) {            
		            	 
		            	 System.out.println(str);
		            	 System.out.println(hmcompany.get(str));
		            	
		         }
		 }
	
	//Close hierarchy end
	 
	  public void insertData(String name,String price,String quantity,String description){
		
		  
		  try {
			 
			Connection connection = getConnectionDetails();
		    
			
			//step-3  Create Prepare Statement
			prepareStatement = connection.prepareStatement("insert into products_table "
					              +"(Name,Price,Quantity,Description)VALUES(?,?,?,?)");
		
		    prepareStatement.setString(1,name);
		    prepareStatement.setString(2, price);
		    prepareStatement.setString(3, quantity);
		    prepareStatement.setString(4, description);
		    
		    //step-4 Execute the statement
		    
		    int i = prepareStatement.executeUpdate();
		    
		    System.out.println("Record inserted successfully " + i);
		    
		} catch (Exception e) {
			
			System.out.println(e);
		}
		  
//		finally {
//			
//			// step-5 close connections in finally block
//			
//			connection.close();
//			prepareStatement.close();
//			
//		}
		  
	}
	
	  //User input method
	 public void getUserInputForProductDetails() {
		 
     System.out.println("Enter the details for products to insert product details in database");
		  
		  for(int i =1; i<3; i++) {
			  
            System.out.println("Enter the product name");
			name=scanner.nextLine();
			
			System.out.println("Enter product price");
			price=scanner.nextLine();
			
			System.out.println("Enter product quantity");
			quantity=scanner.nextLine();
		
			
	        System.out.println("Enter product description");  
			description=scanner.nextLine();
			
			
			ProductDetails p2=new ProductDetails();
			
			p2.insertData(name,price,quantity,description);
			  
		}
	 
	 }
	
	   public static void main(String[] args) throws SQLException {
	
	 
       //  details.getProductDetails();
      //   details.insertData();		
		   
		ProductDetails p =new ProductDetails();
		
		p.getUserInputForProductDetails();
		   
	} 
	   static {
		   
		   System.out.println("Welcome To Amazon Have A Great Shopping");
		   
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
