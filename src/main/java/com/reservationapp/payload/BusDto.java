package com.reservationapp.payload;
import lombok.Data;
import java.util.List;

@Data
public class BusDto {
    private Long id;
    private String busNumber;
    private String busType;
    private double price;
    private int totalSeats;
    private int availableSeats;
}
