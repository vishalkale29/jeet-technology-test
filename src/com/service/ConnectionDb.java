package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	  public static Connection databaseConnectivity() throws SQLException{
			
			Connection con=null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","romeo");    
				
				if(con!=null){
					System.out.println(" Connection Suceessful");
				}
			        
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			return  con;
			
		}
}
