package com.reservationapp.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubRouteDto {
    private Long id;
    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
}
