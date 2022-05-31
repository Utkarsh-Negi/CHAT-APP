package com.firstproject.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.firstproject.chatapp.utils.ConfigReader.getValue;
//Throw early and catch later is an extremely important rule

// As we need commonDAO to create connection but every time when we create an object for it to use then it will use unwanted memory so to avoid this situation we make this common dao a interface because in interface we can use static methods.
public interface CommonDAO {
	public static Connection createConnection() throws ClassNotFoundException, SQLException 
	{
		//Step 1 - Load a driver
		Class.forName(getValue("DRIVER"));
		//Step 2 - Create connection
		final String CONNECTION_STIRNG = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USER_ID");
		final String PASSWORD = getValue("PASSWORD");
		
		Connection con = DriverManager.getConnection(CONNECTION_STIRNG,USER_ID,PASSWORD);
		if(con != null) {
			System.out.println("Connection created...");
			//con.close();
		}
	
	return con;
	
	}
	
	
}
