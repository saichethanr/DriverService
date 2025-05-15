package com.example.DriverService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //from lombok will add the setters and getters automatically
@NoArgsConstructor
@AllArgsConstructor
public class DriverCacheData {
    private String userid;
    private String driverLatitude;
    private String driverLongitude;
}
