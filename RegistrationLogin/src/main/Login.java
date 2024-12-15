package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import controller.DBfunctions;
import controller.createConnection;
import model.Users;




public class Login {
    //private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    

    public static Connection conn=createConnection.connect();
    public static void main(String[] args) throws SQLException {
    	
    	//Connection DB
    	
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. User Registration");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerUser(){
        System.out.print("Customer Name (max 50 chars): ");
        String customerName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Mobile Number (Country Code +XXXXXXXXXX): ");
        String mobileNumber = scanner.nextLine();
        
        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Password (max 30 chars): ");
        String password = scanner.nextLine();

        System.out.print("Confirm Password: ");
        String confirmPassword = scanner.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
            return;
        }

        if (!isValidPassword(password)) {
            System.out.println("Password must contain at least one upper case letter, one lower case letter, and one special character.");
            return;
        }

        System.out.print("role(ADMIN/USER) :");
        String role = scanner.nextLine();


        
        Users user=new Users(customerName, address, mobileNumber, email, password, role);
        
        try {
			DBfunctions.insert(user);
			System.out.println("User registered successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User not registered!");

		}
        
        
        
    }

    private static void loginUser() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

//        for (User user : users) {
//            if (user.userId.equals(userId) && user.password.equals(password)) {
//                
//                // Here you can add role-specific options for the dashboard
//                return;
//            }
//        }
        try {
			ResultSet rs=DBfunctions.records();
			while(rs.next()) {
				if(rs.getString(1).equals(email)&&rs.getString(2).equals(password) )
				{
					System.out.println("Login successful! Welcome to your dashboard.");
				}
			}
			if(!rs.next()) {
				System.out.println("Invalid User ID or Password. Please try again.");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
        
        
    }

    private static boolean isValidUserId(String userId) {
        return userId.length() >= 5 && userId.length() <= 20;
    }

    private static boolean isValidPassword(String password) {
        // Check for at least one uppercase letter, one lowercase letter, and one special character
        return Pattern.compile("[A-Z]").matcher(password).find() &&
               Pattern.compile("[a-z]").matcher(password).find() &&
               Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }
}
