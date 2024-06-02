package com.ride.shareride.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.shareride.entity.Booking;
import com.ride.shareride.entity.Payment;
import com.ride.shareride.entity.PaymentRequest;
import com.ride.shareride.repositrory.BookingRepository;
import com.ride.shareride.repositrory.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Payment processPayment(PaymentRequest paymentRequest) {
        Booking booking = bookingRepository.findById(paymentRequest.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentStatus("COMPLETED");
        payment.setPaymentTime(LocalDateTime.now());

        return paymentRepository.save(payment);
    }
}
