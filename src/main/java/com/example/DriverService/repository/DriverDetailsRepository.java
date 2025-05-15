package com.example.DriverService.repository;

import com.example.DriverService.model.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDetailsRepository extends JpaRepository<DriverDetails,String> {
}
