package com.ride.shareride.repositrory;


import org.springframework.data.repository.CrudRepository;

import com.ride.shareride.entity.Ride;

import java.time.LocalDateTime;
import java.util.List;

public interface RideRepository extends CrudRepository<Ride, Long> {
    List<Ride> findByDepartureLocationAndDestinationAndDepartureTime(
            String departureLocation, String destination, LocalDateTime departureTime);
}
