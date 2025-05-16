package com.example.DriverService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //from lombok will add the setters and getters automatically
@NoArgsConstructor
@AllArgsConstructor
public class DriverCacheData {
    private String userid;
    private double driverLatitude;
    private double driverLongitude;
    private int seats;
}
