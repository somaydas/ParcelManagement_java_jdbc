package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import controller.DBfunctions;
import controller.createConnection;
import model.Booking;


public class CustomerDashboard {
    //private static ArrayList<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static Connection conn=createConnection.connect();
    public static String senderName = "Somay Das";
    public static String senderAddress = "859,MotilaL Gupta Road, Kolkata-700082";
    public static String senderContactDetails = "9748537451";

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Welcome "+senderName+" ---");
            System.out.println("1. Home");
            System.out.println("2. Booking Service");
            System.out.println("3. Tracking");
            System.out.println("4. Previous Booking");
            System.out.println("5. Contact Support");
            System.out.println("6. Logout");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Home - Just display a welcome message
                    System.out.println("Welcome to the Booking Service!");
                    break;

                case 2:
                    bookService();
                    break;

                case 3:
                    trackBooking();
                    break;

                case 4:
                    viewPreviousBookings();
                    break;

                case 5:
                    //contactSupport();
                    break;

                case 6:
                    System.exit(1);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
        //scanner.close();
    }

    private static void bookService() {
        // Capture sender details (for simplicity, hardcoded)
        

//       Display sender details
        System.out.println("\nSender Details:");
        System.out.println("Name: " + senderName);
        System.out.println("Address: " + senderAddress);
        System.out.println("Contact Details: " + senderContactDetails);

        // Capture booking details from user
        
        System.out.print("\nEnter Receiver Name: ");
        String recName = scanner.nextLine();

        System.out.print("Enter Receiver Address: ");
        String recAddress = scanner.nextLine();

        System.out.print("Enter Receiver Pin: ");
        int recPin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Receiver Mobile: ");
        String recMobile = scanner.nextLine();

        System.out.print("Enter Parcel Weight (grams): ");
        double parWeightGram =scanner.nextDouble();
        
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Parcel Contents Description: ");
        String parContentsDescription = scanner.nextLine();

        System.out.print("Enter Parcel Delivery Type: ");
        String parDeliveryType =scanner.nextLine();

        System.out.print("Enter Parcel Packing Preference: ");
        String parPackingPreference = scanner.nextLine();

        // Capture pickup and dropoff times
		System.out.print("Enter Parcel Pickup Time (yyyy-MM-dd HH:mm:ss): ");
		String pickupTime = scanner.nextLine();
	

		System.out.print("Enter Parcel Dropoff Time (yyyy-MM-dd HH:mm:ss): ");
		String dropoffTime=scanner.nextLine();

		// Create booking and add to list
		Booking booking = new Booking(senderName,senderAddress,senderContactDetails,recName, recAddress, recPin, recMobile,
				parWeightGram, parContentsDescription, parDeliveryType,
				parPackingPreference, pickupTime, dropoffTime);
//		
		
		try {
			DBfunctions.insert(booking);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Not registered");
			e.printStackTrace();
		}
		

		// Display invoice
		booking.displayInvoice();
	}

	private static void trackBooking() {
		System.out.print("\nEnter Booking ID to track: ");
		String bookingIDToTrack = scanner.nextLine();
		
		try {
			ResultSet rs=DBfunctions.track(bookingIDToTrack);
			while(rs.next()) {
			System.out.println("\nTracking Status:");
			System.out.println("Booking ID: "+rs.getString(1));
			System.out.println("Sender Name: "+rs.getString(2));
			System.out.println("Sender Address: "+rs.getString(3));
			System.out.println("Receiver Name "+rs.getString(4));
			System.out.println("Receiver Address "+rs.getString(5));
			System.out.println("Date of Booking: "+rs.getString(6));
			System.out.println("Status: "+rs.getString(7));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Booking ID not found.");
			e.printStackTrace();
		}
		


		
//		
	}


//
	private static void viewPreviousBookings() {
		
		try {
			ResultSet rs=DBfunctions.BookingHistory(senderName);
			int i=1;
			while(rs.next()) {
				System.out.println("Booking :"+i++);
				System.out.println("Customer Id "+rs.getInt(1));
				System.out.println("Booking Id "+rs.getString(2));
				System.out.println("Booking Date "+rs.getString(3));
				System.out.println("Receiver Name "+rs.getString(4));
				System.out.println("Delivered Address "+rs.getString(5));
				System.out.println("Amount "+rs.getDouble(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No bookings found");
			e.printStackTrace();
		}
	}
}

