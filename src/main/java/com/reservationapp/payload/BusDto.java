package com.reservationapp.payload;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BusDto {

    private Long busId;
    private String busNumber;
    private String busType;
    private String fromLocation;
    private String toLocation;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String totalDuration;
    private LocalTime fromTime;
    private LocalTime toTime;
    private double price;
    private int totalSeats;
    private int availableSeats;
}
