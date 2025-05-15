package com.example.DriverService.controller;

import com.example.DriverService.model.DriverDetails;
import com.example.DriverService.model.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driverservice")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/driverdetails")
    public ResponseEntity<String> saveDriverDetails(@RequestBody DriverDetails driverDetails) {
        driverService.saveDriverDetails(driverDetails);
        return ResponseEntity.ok("Driver details saved successfully");
    }
}