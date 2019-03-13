import java.io.*;
import java.util.ArrayList;

public class FilePrinter {
	private String directory;
	private String filename;
	private ArrayList<Car> cars;
	
	FilePrinter(String directory, String filename, ArrayList<Car> cars){
		this.directory = directory;
		this.filename = filename;
		this.cars = cars;
	}
	
	void print() {
		String path = this.directory + this.filename;
	    for (int i=0; i<this.cars.size(); i++) {
		    try {
				FileWriter fw = new FileWriter(path, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);
				
				int id = this.cars.get(i).getID();
				String year = this.cars.get(i).getYear();
				String manufacturer = this.cars.get(i).getManufacturer();
				String make = this.cars.get(i).getMake();
				String model = this.cars.get(i).getModel();
				
				out.print("\n--------\n");
				out.print(id + ": " + year + manufacturer + make + model);
				out.close();
					
			} catch (IOException e) {
				e.printStackTrace();
			}	       
	    }
	    System.out.print("\n--------\n");
	    System.out.print("File written successfully");
	}

}

