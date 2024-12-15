package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class createConnection {
	public static final String url="jdbc:sqlite:C:\\Users\\dasbi\\database";
	public static Connection connect() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(url);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
