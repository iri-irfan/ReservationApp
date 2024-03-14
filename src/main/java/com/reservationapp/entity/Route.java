package com.reservationapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;

    @Column(name = "bus_id", unique = true,nullable = false)
    public Long busId;




//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "bus_id")
//    private Bus bus;
//
//    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<SubRoute> subRoutes;

    // Constructors, getters, setters
}
