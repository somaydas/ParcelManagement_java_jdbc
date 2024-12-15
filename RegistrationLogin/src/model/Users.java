package model;

public class Users {
    String customerName;
    public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	String email;
    String mobileNumber;
    String address;
    String password;
    String role;

    public Users(String customerName, String address, String mobileNumber, String email, String password, String role) {
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.password = password;
        this.role = role;
    }
}