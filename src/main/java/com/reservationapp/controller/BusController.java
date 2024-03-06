package com.reservationapp.controller;

import com.reservationapp.entity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

//    @Autowired
//    private BusService busService;

    // Create a new bus using request parameters
    @PostMapping("/create")
    public Bus createBus(
            @RequestParam String busNumber,
            @RequestParam String busType,
            @RequestParam String fromLocation,
            @RequestParam String toLocation,
            @RequestParam("fromDate") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate fromDate,
            @RequestParam("toDate") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate toDate,
            @RequestParam String totalDuration,
            @RequestParam("fromTime") @DateTimeFormat(pattern = "HH:mm") LocalTime fromTime,
            @RequestParam("toTime") @DateTimeFormat(pattern = "HH:mm") LocalTime toTime,
            @RequestParam double price,
            @RequestParam int totalSeats,
            @RequestParam int availableSeats
    ) {
        Bus bus = new Bus();
        bus.setBusNumber(busNumber);
        bus.setBusType(busType);
        bus.setFromLocation(fromLocation);
        bus.setToLocation(toLocation);
        bus.setFromDate(fromDate);
        bus.setToDate(toDate);
        bus.setTotalDuration(totalDuration);
        bus.setFromTime(fromTime);
        bus.setToTime(toTime);
        bus.setPrice(price);
        bus.setTotalSeats(totalSeats);
        bus.setAvailableSeats(availableSeats);

        return null;
    }


}

