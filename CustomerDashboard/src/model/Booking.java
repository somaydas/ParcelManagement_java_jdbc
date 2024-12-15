package model;


import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking {
    String bookingID;
    String SenderName;
	String SenderAddress;
    String SenderMobile;
    String receiverName;
    String receiverAddress;
    int receiverPin;
    String receiverMobile;
    double parcelWeight;
    String parcelContentsDescription;
    String parcelDeliveryType;
    String parcelPackingPreference;
    String pickupTime;
    String dropoffTime;
    double serviceCost;
    LocalDateTime paymentTime;
    String status;

    public Booking(String senderName,String senderAddress,String senderMobile,String receiverName, String receiverAddress, int receiverPin, String receiverMobile,
                   double parcelWeight, String parcelContentsDescription, String parcelDeliveryType,
                   String parcelPackingPreference, String pickupTime, String dropoffTime) {
        this.bookingID = generateBookingID();
        this.SenderName=senderName;
        this.SenderAddress=senderAddress;
        this.SenderMobile=senderMobile;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverPin = receiverPin;
        this.receiverMobile = receiverMobile;
        this.parcelWeight = parcelWeight;
        this.parcelContentsDescription = parcelContentsDescription;
        this.parcelDeliveryType = parcelDeliveryType;
        this.parcelPackingPreference = parcelPackingPreference;
        this.pickupTime = pickupTime;
        this.dropoffTime = dropoffTime;
        this.serviceCost = calculateServiceCost(parcelWeight);
        this.paymentTime = LocalDateTime.now();
    }

    private String generateBookingID() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    private double calculateServiceCost(double weight) {
        // Example cost calculation: $5 per 100 grams
        return (weight / 100) * 5.0;
    }

    public void displayInvoice() {
        System.out.println("Booking Invoice:");
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Receiver Name: " + receiverName);
        System.out.println("Receiver Address: " + receiverAddress);
        System.out.println("Receiver Pin: " + receiverPin);
        System.out.println("Receiver Mobile: " + receiverMobile);
        System.out.println("Parcel Weight (g): " + parcelWeight);
        System.out.println("Parcel Contents Description: " + parcelContentsDescription);
        System.out.println("Parcel Delivery Type: " + parcelDeliveryType);
        System.out.println("Parcel Packing Preference: " + parcelPackingPreference);
        System.out.println("Parcel Pickup Time: " + pickupTime);
        System.out.println("Parcel Dropoff Time: " + dropoffTime);
        System.out.println("Parcel Service Cost: $" + serviceCost);
        System.out.println("Parcel Payment Time: " + paymentTime);
    }

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public int getReceiverPin() {
		return receiverPin;
	}

	public void setReceiverPin(int receiverPin) {
		this.receiverPin = receiverPin;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public double getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(double parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public String getParcelContentsDescription() {
		return parcelContentsDescription;
	}

	public void setParcelContentsDescription(String parcelContentsDescription) {
		this.parcelContentsDescription = parcelContentsDescription;
	}

	public String getParcelDeliveryType() {
		return parcelDeliveryType;
	}

	public void setParcelDeliveryType(String parcelDeliveryType) {
		this.parcelDeliveryType = parcelDeliveryType;
	}

	public String getParcelPackingPreference() {
		return parcelPackingPreference;
	}

	public void setParcelPackingPreference(String parcelPackingPreference) {
		this.parcelPackingPreference = parcelPackingPreference;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getDropoffTime() {
		return dropoffTime;
	}

	public void setDropoffTime(String dropoffTime) {
		this.dropoffTime = dropoffTime;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public String getPaymentTime() {
		return "2024-12-15 11:36";
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    public String getSenderName() {
		return SenderName;
	}

	public String getSenderAddress() {
		return SenderAddress;
	}

	public String getSenderMobile() {
		return SenderMobile;
	}

	public void setSenderName(String senderName) {
		SenderName = senderName;
	}

	public void setSenderAddress(String senderAddress) {
		SenderAddress = senderAddress;
	}

	public void setSenderMobile(String senderMobile) {
		SenderMobile = senderMobile;
	}
}
