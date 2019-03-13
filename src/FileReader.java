import java.io.*;
import java.util.*;

public class FileReader {
	private String directory;
	private String filename;
	
	FileReader(String directory, String filename){
		this.directory = directory;
		this.filename = filename;	
	}
	
	ArrayList<Car> read() {
		int current_row;
	    int iterator;

	    int id_index = 0;
	    int manufacturer_index = 0;
	    int make_index = 0;
	    int model_index = 0;
	    int year_index = 0;
	   
	    String data;
	    int id = 0;
	    String manufacturer = "";
	    String make = "";
	    String model = "";
	    String year = "";
		
	    String path = this.directory + this.filename;
		File current_file = new File(path);
	    Scanner fileScanner;
	    
	    ArrayList<Car> cars = new ArrayList<Car>();
	
		try {
			fileScanner = new Scanner(current_file);
			current_row = 1;
		   	
			 while (fileScanner.hasNextLine()) {
			    	String line = fileScanner.nextLine();
			    	
			    	Scanner lineScanner = new Scanner(line);
			    	lineScanner.useDelimiter(",");
			    	iterator = 0;
			    	
			        while (lineScanner.hasNext()) {  
			        			
			        	if(current_row == 1) {		
			        		data = lineScanner.next();
			        		
	    	        		//Create column index's
			        		if(data.contains("ID")) {id_index = iterator;}
	    	        		if(data.contains("Manufacturer")) {manufacturer_index = iterator;}
	    	        		if(data.contains("Make")) {make_index = iterator;}  
	    	        		if(data.contains("Model")) {model_index = iterator;}
	    	        		if(data.contains("Year")) {year_index = iterator;}
	    	        		
		    	        } else {
		    	        	data = lineScanner.next();
			        		
		    	        	//Use column index's to assign proper values
		    	        	if(iterator == id_index) {id = Integer.parseInt(data);}
		    	        	if(iterator == manufacturer_index) {manufacturer = data;}	
		    	        	if(iterator == make_index) {make = data;}
		    	        	if(iterator == model_index) {model = data;}
		    	        	if(iterator == year_index) {year = data;}
		    	        }
			        	
		    	        iterator++;  
			        }
			        if(current_row != 1) {
			        	cars.add(new Car(id, manufacturer, make, model, year));
			        }
			        current_row++;
			        System.out.print("\n");
			        lineScanner.close();  
		        	//end of line     
			    }     
			    fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return cars;
	}		
}
