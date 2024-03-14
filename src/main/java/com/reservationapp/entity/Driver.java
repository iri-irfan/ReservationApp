package com.reservationapp.entity;

import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String driverName;
    private String driverLicenseNumber;
    private String aadharNumber;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private String emailId;

}
