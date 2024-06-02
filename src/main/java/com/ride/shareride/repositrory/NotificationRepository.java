package com.ride.shareride.repositrory;

import org.springframework.data.repository.CrudRepository;

import com.ride.shareride.entity.Notification;



public interface NotificationRepository extends CrudRepository<Notification, Long> {
    // List<Notification> findByUserId(Long userId);
}
