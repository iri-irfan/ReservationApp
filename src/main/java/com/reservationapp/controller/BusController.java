package com.reservationapp.controller;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Driver;
import com.reservationapp.payload.BusDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.DriverRepository;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping("/add-bus")
    public ResponseEntity<?> addBus(@RequestBody BusDto busDto){
        BusDto dto = busService.addBus(busDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


}

