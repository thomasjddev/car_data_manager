
//Class to hold car object data
public class Car {
	private int id;
	private String manufacturer;
	private String make;
	private String model;
	private String year;

	/**
	* Constructor for objects of type Car
	*/
	public Car(int id, String manufacturer, String make, String model, String year)
	{
		this.id = id;
		this.manufacturer = manufacturer;
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public int getID() {return this.id;}
	public String getManufacturer() {return this.manufacturer;}
	public String getMake() {return this.make;}
	public String getModel() {return this.model;}
	public String getYear() {return this.year;}
	
	public void printInfo() {
		System.out.print(this.id + ":" + this.year + this.manufacturer + this.make + this.model + "\n");
	}
	
}

