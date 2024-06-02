package com.ride.shareride.repositrory;


import org.springframework.data.repository.CrudRepository;

import com.ride.shareride.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
