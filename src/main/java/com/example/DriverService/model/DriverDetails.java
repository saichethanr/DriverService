package com.example.DriverService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="driver_det")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDetails {
    @Id
    private String userId;

    private String date;

    private double driverLatitude;
    private double driverLongitude;

    private double destinationLatitude;
    private double destinationLongitude;

    private String model;
    private String make;
    private int seats;
    private String color;
}
