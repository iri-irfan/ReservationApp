package com.reservationapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long busId;
        @Column(name = "bus_number", unique = true )
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
