import java.sql.*;

//Database connection class
public class DatabaseConnection {
	private String host;
	private String db;
	private String user;
	private String password;
	private Connection connection;
	 
	/**
	* Initialize Database Connection
	*/
	public DatabaseConnection(String host, String db, String user, String password)
	{
		this.host = host;
		this.db = db;
		this.user = user;
		this.password= password;
		String path ="jdbc:mysql://" + this.host + "/" + this.db;
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
	    	Connection con=DriverManager.getConnection(path, this.user, this.password);  	    	
			this.connection = con;
			System.out.println("Connection Established");
		} catch(Exception e){ 
			System.out.println(e);
			System.out.println("Connection Failed");	
		} 
	} 
	
	/**
	* Returns current open connection 
	* *@return Connection Object
	*/
	public Connection getConnection() {
		return this.connection;	
	}
}

