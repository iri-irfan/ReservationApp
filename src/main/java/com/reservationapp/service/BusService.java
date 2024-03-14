package com.reservationapp.service;
import com.reservationapp.entity.*;
import com.reservationapp.payload.*;
import com.reservationapp.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private SubRouteRepository subRouteRepository;


    public BusService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    Bus mapToEntityForBus(BusDto busDto) {
        Bus bus = modelMapper.map(busDto, Bus.class);
        return bus;
    }
BusDto mapToDto(Bus bus){
    BusDto dto = modelMapper.map(bus, BusDto.class);
    return dto;
}

    SubRoute mapToEntityForSubRoute(SubRouteDto subRouteDto) {
        SubRoute mapped = modelMapper.map(subRouteDto, SubRoute.class);
        return mapped;
    }

    public BusDto addBus(BusDto busDto) {

        Bus bus = mapToEntityForBus(busDto);
        Bus savedBus = busRepository.save(bus);
        BusDto dto = mapToDto(savedBus);
        return dto;

    }
}













