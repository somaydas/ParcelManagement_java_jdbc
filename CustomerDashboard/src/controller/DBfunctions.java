package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Booking;

public class DBfunctions {
	public static Connection conn=createConnection.connect();
	public static void create() throws SQLException {
		String createTableSQL="create table Bookings(\r\n"
				+ "Booking_id varchar(100) primary key not null,\r\n"
				+ "Sender_name varchar(100),\r\n"
				+ "Sender_address varchar(100),\r\n"
				+ "Sender_contact varchar(20),\r\n"
				+ "Receiver_name varchar(100),\r\n"
				+ "Receiver_address varchar(100),\r\n"
				+ "Receiver_pin integer(15),\r\n"
				+ "Receiver_mobile varchar(20),\r\n"
				+ "Parcel_weight double,\r\n"
				+ "Parcel_content_desc varchar(100),\r\n"
				+ "Parcel_delivery_type varchar(100),\r\n"
				+ "Parcel_packing_preferences varchar(100),\r\n"
				+ "Pickup_time DATETIME NOT NULL,\r\n"
				+ "Dropoff_time DATETIME NOT NULL,\r\n"
				+ "Service_cost double,\r\n"
				+ "Payment_time DATETIME NOT NULL,\r\n"
				+ "Status varchar(100) default \"pending\" not null);";
		Statement stmt=conn.createStatement();
		stmt.execute(createTableSQL);
	}
	
	public static void insert(Booking booking) throws SQLException {
		PreparedStatement ptmt=conn.prepareStatement("insert into Bookings(Booking_id,Sender_name,Sender_address,Sender_contact,Receiver_name,Receiver_address,Receiver_pin,Receiver_mobile,Parcel_weight,Parcel_content_desc,Parcel_delivery_type,Parcel_packing_preferences,Pickup_time,Dropoff_time,Service_cost,Payment_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ptmt.setString(1, booking.getBookingID());
		ptmt.setString(2,booking.getSenderName());
		ptmt.setString(3,booking.getSenderAddress());
		ptmt.setString(4,booking.getSenderMobile());	
		ptmt.setString(5,booking.getReceiverName());
		ptmt.setString(6,booking.getReceiverAddress());
		ptmt.setInt(7,booking.getReceiverPin());
		ptmt.setString(8, booking.getReceiverMobile());
		ptmt.setDouble(9,booking.getParcelWeight());
		ptmt.setString(10,booking.getParcelContentsDescription());
		ptmt.setString(11,booking.getParcelDeliveryType());
		ptmt.setString(12,booking.getParcelPackingPreference());
		ptmt.setString(13,booking.getPickupTime());
		ptmt.setString(14,booking.getDropoffTime());
		ptmt.setDouble(15,booking.getServiceCost());
		ptmt.setString(16,booking.getPaymentTime());
		System.out.println("HI");
		
		

		ptmt.executeUpdate();


	}
	public static ResultSet track(String Bid) throws SQLException {

		PreparedStatement ptmt=conn.prepareStatement("select Booking_id,Sender_name,Sender_address,Receiver_name,Receiver_address,Payment_time,Status from Bookings where Booking_id=?");
		ptmt.setString(1, Bid);
		
		ResultSet rs=ptmt.executeQuery();
		return rs;
	}
	
	public static ResultSet BookingHistory(String user) throws SQLException {

		PreparedStatement ptmt=conn.prepareStatement("select UserId,Booking_id,Payment_time,Receiver_name,Receiver_Address,Service_cost FROM Bookings,UserProfile where Fullname=?;");
		ptmt.setString(1,user);
		
		ResultSet rs=ptmt.executeQuery();
		
		
		return rs;
	}
	
	

}
