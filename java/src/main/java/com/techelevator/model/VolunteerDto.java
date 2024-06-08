package com.techelevator.model;

public class VolunteerDto {

    private int volunteerId;
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String zipCode;
    private String approvalStatus;

    public int getVolunteerId() {
        return volunteerId;
    }
    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "--- SHELTERED FURRY FRIENDS ---\n\n" +
                "First Name:\t" + firstName + "\n" +
                "Last Name:\t" + lastName + "\n" +
                "Email Address:\t" + email + "\n" +
                "Phone Number:\t" + phoneNumber + "\n" +
                "Zip Code:\t" + zipCode + "\n" +
                "Volunteer Application Status:\t" + approvalStatus + "\n";
    }
}
