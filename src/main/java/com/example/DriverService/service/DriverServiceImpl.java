package com.example.DriverService.service;

import com.example.DriverService.model.DriverCacheData;
import com.example.DriverService.model.DriverDetails;
import com.example.DriverService.model.DriverService;
import com.example.DriverService.repository.DriverDetailsRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverDetailsRepository repository;
    private final RedisTemplate<String, DriverCacheData> redisTemplate;

    public DriverServiceImpl(DriverDetailsRepository repository, RedisTemplate<String, DriverCacheData> redisTemplate) {
        this.repository = repository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void saveDriverDetails(DriverDetails driverDetails) {
        // Save to PostgreSQL
        repository.save(driverDetails);

        // Save to Redis (cache)
        DriverCacheData cacheData = new DriverCacheData(
                driverDetails.getUserId(),
                driverDetails.getDriverLatitude(),
                driverDetails.getDriverLongitude(),
                driverDetails.getSeats()
        );

        redisTemplate.opsForValue().set(driverDetails.getUserId(), cacheData);
    }
}
