package com.example.DriverService.service;

import com.example.DriverService.model.DriverCacheData;
import com.example.DriverService.model.DriverDetails;
import com.example.DriverService.model.DriverService;
import com.example.DriverService.repository.DriverDetailsRepository;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverDetailsRepository repository;
    private final RedisTemplate<String, String> redisTemplate;

    public DriverServiceImpl(DriverDetailsRepository repository, RedisTemplate<String, String> redisTemplate) {
        this.repository = repository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void saveDriverDetails(DriverDetails driverDetails) {
        // 1. Save to PostgreSQL
        repository.save(driverDetails);

        // 2. Add location to Redis GEO set
        Point location = new Point(driverDetails.getDriverLongitude(), driverDetails.getDriverLatitude());
        redisTemplate.opsForGeo().add("drivers:locations", location, driverDetails.getUserId());

        // 3. Add metadata (seats) in Hash
        Map<String, String> driverMeta = new HashMap<>();
        driverMeta.put("seats", String.valueOf(driverDetails.getSeats()));
        driverMeta.put("latitude", String.valueOf(driverDetails.getDriverLatitude()));
        driverMeta.put("longitude", String.valueOf(driverDetails.getDriverLongitude()));

        redisTemplate.opsForHash().putAll("driver:" + driverDetails.getUserId(), driverMeta);
    }
}
