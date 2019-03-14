import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String[] args) {
	    
	    ArrayList<Car> cars;
	    
	    //UI Module
	    int menuSelect = 0;
	    Scanner in = new Scanner(System.in);
	   
		System.out.print("Welcome to the Car Data Manager\n");	
		System.out.print("--------\n\n");
				   
		
		System.out.print("Please choose an option...\n\n");
		
		System.out.print("1. Read a file\n");
		System.out.print("2. Read database\n");
		System.out.print("3. Enter new data\n");
		System.out.print("4. search records\n");
				    
		System.out.print("\nPlease enter choice: ");
		menuSelect = in.nextInt();
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		
		switch(menuSelect){
			case 1:
				System.out.print("Please choose an option...\n\n");
				
				System.out.print("1. Write to screen\n");
				System.out.print("2. Write to file\n");
				System.out.print("3. Write to database\n");
				
				System.out.print("\nPlease enter choice: ");
				menuSelect = in.nextInt();
				System.out.print("\n\n\n\n\n\n\n\n\n\n");
				
				switch(menuSelect){
					case 1:
						break;
					case 2:
						System.out.print("Please choose an option...\n\n");
						
						System.out.print("1. Use test file\n");
						System.out.print("2. Enter file name\n");
						
						System.out.print("\nPlease enter choice: ");
						menuSelect = in.nextInt();
						System.out.print("\n\n\n\n\n\n\n\n\n\n");
						break;
					case 3:
						break;
				}					
				break;
			
			case 2:
				System.out.print("2. Read Database\n");
				break;
			
			case 3:
				System.out.print("3. Enter New Data\n");
				break;
			
			case 4:
				System.out.print("4. Search Records\n");
				break;		
		}
			    
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
		FilePrinter fp = new FilePrinter("/Users/apple/Desktop/", "car_directory.txt", cars);
		fp.print();	
		
		
		System.out.print("\n--------\n");
		
		//Excel Module
		try {
            FileInputStream file = new FileInputStream(new File("/Users/apple/Desktop/test.xlsx"));

            //Create Workbook instance
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first sheet from workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each row
            Iterator<Row> rowIterator = sheet.iterator();
           
            //Reset indexes on new file
			int current_row = 1;
		    int iterator = 0;
		    
		    
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
				
                while (cellIterator.hasNext()) 
                {
               		//Cell cell = cellIterator.next();
               		System.out.print(cellIterator.next() + " ");
	    	        iterator++;             
	        	}
	        	current_row++;
	        	System.out.print("\n");
                }
            file.close();     
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	    		
	}
}
