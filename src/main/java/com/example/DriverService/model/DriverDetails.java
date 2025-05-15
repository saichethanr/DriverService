package com.example.DriverService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="driver_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDetails {
    @Id
        private String userId;

    private String date;

    private String driverLatitude;
    private String driverLongitude;

    private String destinationLatitude;
    private String destinationLongitude;

    private String model;
    private String make;
    private int seats;
    private String color;
}
