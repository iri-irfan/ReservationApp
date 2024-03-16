package com.reservationapp.service;
import com.reservationapp.entity.*;
import com.reservationapp.payload.*;
import com.reservationapp.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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


    public BusDto addBus(BusDto busDto) {

        Bus bus = mapToEntityForBus(busDto);
        Bus savedBus = busRepository.save(bus);
        BusDto dto = mapToDto(savedBus);
        return dto;

    }

    public List<SearchListOfBusesDto> getAllBuses(String fromLocation, String toLocation, String fromDate) {

        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SubRoute> subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SearchListOfBusesDto> buses = new ArrayList<>();


        if (routes !=null){
            for (Route route: routes){
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBusesDto searchListofBusesDto = maptoSearchListOfBusesDto(bus, route);
                buses.add(searchListofBusesDto);
            }
            return buses;
        }
        if (subRoutes !=null){
            for (SubRoute route : subRoutes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBusesDto searchListofBusesDto = maptoListOfBusDtos(bus, route);
                buses.add(searchListofBusesDto);
            }
            return buses;
        }


        return null;
    }















    SearchListOfBusesDto maptoSearchListOfBusesDto(Bus bus, Route route) {
        SearchListOfBusesDto searchListofBusesDto = modelMapper.map(bus, SearchListOfBusesDto.class);
        modelMapper.map(route, searchListofBusesDto);
        return searchListofBusesDto;
    }

    SearchListOfBusesDto maptoListOfBusDtos(Bus bus, SubRoute route) {
        SearchListOfBusesDto searchListofBusesDto = modelMapper.map(bus, SearchListOfBusesDto.class);
        modelMapper.map(route, searchListofBusesDto);
        return searchListofBusesDto;
    }

    Bus mapToEntityForBus(BusDto busDto) {
        Bus bus = modelMapper.map(busDto, Bus.class);
        return bus;
    }
    BusDto mapToDto(Bus bus){
        BusDto dto = modelMapper.map(bus, BusDto.class);
        return dto;
    }




}













