package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Users;

public class DBfunctions {
	public static Connection conn=createConnection.connect();
	
	public static void create() throws SQLException {
		String createTableSQL="create table UserProfile(\r\n"
				+ "UserId integer primary key autoincrement,\r\n"
				+ "FullName varchar(100) not null,\r\n"
				+ "Address varchar(100),\r\n"
				+ "Email varchar(100) not null unique,\r\n"
				+ "MobileNumber varchar(20),\r\n"
				+ "Password varchar(100),\r\n"
				+ "Role varhcar(100));";
		Statement stmt=conn.createStatement();
		stmt.execute(createTableSQL);
	}
	
	public static void insert(Users user) throws SQLException {
		PreparedStatement ptmt=conn.prepareStatement("insert into UserProfile(FullName,Address,Email,MobileNumber,Password,Role) values(?,?,?,?,?,?)");
		ptmt.setString(1, user.getCustomerName());
		ptmt.setString(2,user.getAddress());
		ptmt.setString(3,user.getEmail());
		ptmt.setString(4,user.getMobileNumber());	
		ptmt.setString(5,user.getPassword());
		ptmt.setString(6,user.getRole());
		
		ptmt.execute();


	}
	
	public static ResultSet records() throws SQLException {
		Statement stmt=conn.createStatement();
		return stmt.executeQuery("select Email,Password from UserProfile");
	}

}
