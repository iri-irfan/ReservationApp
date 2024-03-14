package com.reservationapp.controller;

import com.reservationapp.payload.BusDto;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

