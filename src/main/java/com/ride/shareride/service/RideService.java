package com.ride.shareride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.shareride.entity.Ride;

import com.ride.shareride.repositrory.RideRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public List<Ride> searchRides(String departureLocation, String destination, LocalDateTime departureTime) {
        return rideRepository.findByDepartureLocationAndDestinationAndDepartureTime(departureLocation, destination, departureTime);
    }

    public List<Ride> getCourses() {
        List<Ride> list=(List<Ride>) rideRepository.findAll();
        return list;
    }
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));
    }
}