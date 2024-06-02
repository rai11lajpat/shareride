package com.ride.shareride.repositrory;


import org.springframework.data.repository.CrudRepository;

import com.ride.shareride.entity.Booking;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    // List<Booking> findByRideId(Long rideId);
}
