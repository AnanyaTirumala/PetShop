package com.amdocs.petStore.dao;

import java.sql.*;
import java.sql.DriverManager;

public class PetConnection {
	
	static Connection con;
	
	public static Connection getConnection() {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver"); //registration
			 con=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger");
		 }catch(Exception e) {
			 System.out.println("error in connection" + e.getMessage());
		 }
		 return con;
	 }

}
