package com.ride.shareride.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ride.shareride.entity.Booking;
import com.ride.shareride.entity.BookingRequest;
import com.ride.shareride.entity.BookingStatusUpdateRequest;
import com.ride.shareride.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> bookRide(@RequestBody BookingRequest bookingRequest) {
        Booking booking = bookingService.bookRide(bookingRequest);
        return ResponseEntity.ok(booking);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Booking> updateBookingStatus(
            @PathVariable Long id, @RequestBody BookingStatusUpdateRequest statusUpdateRequest) {
        Booking updatedBooking = bookingService.updateBookingStatus(id, statusUpdateRequest);
        return ResponseEntity.ok(updatedBooking);
    }
}
