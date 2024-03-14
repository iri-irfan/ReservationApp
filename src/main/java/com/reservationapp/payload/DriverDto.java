package com.reservationapp.payload;

import lombok.Data;

@Data
public class DriverDto {
    private String driverName;
    private String driverLicenseNumber;
    private String aadharNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;
}

