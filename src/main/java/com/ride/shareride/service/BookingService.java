package com.ride.shareride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.shareride.entity.Booking;
import com.ride.shareride.entity.BookingRequest;
import com.ride.shareride.entity.BookingStatusUpdateRequest;
import com.ride.shareride.entity.Ride;
import com.ride.shareride.entity.User;
import com.ride.shareride.repositrory.BookingRepository;
import com.ride.shareride.repositrory.RideRepository;
import com.ride.shareride.repositrory.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking bookRide(BookingRequest bookingRequest) {
        Ride ride = rideRepository.findById(bookingRequest.getRideId())
                .orElseThrow(() -> new RuntimeException("Ride not found"));
        
        User passenger = userRepository.findById(bookingRequest.getPassengerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (ride.getAvailableSeats() <= 0) {
            throw new RuntimeException("No available seats");
        }

        Booking booking = new Booking();
        booking.setRide(ride);
        booking.setPassenger(passenger);
        booking.setBookingStatus("PENDING");
        booking.setBookingTime(LocalDateTime.now());

        // Decrease available seats in the ride
        ride.setAvailableSeats(ride.getAvailableSeats() - 1);
        rideRepository.save(ride);

        return bookingRepository.save(booking);
    }

    public Booking updateBookingStatus(Long id, BookingStatusUpdateRequest statusUpdateRequest) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setBookingStatus(statusUpdateRequest.getBookingStatus());
        return bookingRepository.save(booking);
    }

    // public List<Booking> getBookingsByRideId(Long rideId) {
    //     return bookingRepository.findByRideId(rideId);
    // }
}
