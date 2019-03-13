import java.io.*;
import java.sql.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
	    
	    ArrayList<Car> cars;
	    
	    //Database Module
	    try{ 
	    	DatabaseConnection dbcon = new DatabaseConnection("localhost:8889", "car_listing", "root", "root"); 
	    	Connection con = dbcon.getConnection();
	    	
	    	Statement stmt=con.createStatement();  
	    	ResultSet rs=stmt.executeQuery("select * from vehicle");  
	    	while(rs.next())  
	    	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));  
	    	
	    	con.close();	
	    }catch(Exception e){ 
	    	System.out.println(e);
	    }  
	     
	    	 
		
			    
	    //Read from file
		FileReader fr = new FileReader("/Users/apple/Documents/", "file_example.txt");
		cars = fr.read();
			    
		//Print to screen
		System.out.print("List of cars on file: \n\n");
		for (int i=0; i<cars.size(); i++) {
			cars.get(i).printInfo();
		}
			    
		//Print to file
		FilePrinter fp = new FilePrinter("/Users/apple/Desktop/", "car-directory.txt", cars);
		fp.print();	
	}
}
