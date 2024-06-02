package com.ride.shareride.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ride.shareride.entity.Notification;
import com.ride.shareride.entity.NotificationRequest;
import com.ride.shareride.entity.User;
import com.ride.shareride.repositrory.NotificationRepository;
import com.ride.shareride.repositrory.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    public Notification createNotification(NotificationRequest notificationRequest) {
        User user = userRepository.findById(notificationRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Notification notification = new Notification();
        notification.setUser(user);
        notification.setNotificationType(notificationRequest.getNotificationType());
        notification.setNotificationMessage(notificationRequest.getNotificationMessage());
        notification.setNotificationTime(LocalDateTime.now());

        return notificationRepository.save(notification);
    }

    // public List<Notification> getNotificationsByUserId(Long userId) {
    //     return notificationRepository.findByUserId(userId);
    // }
}
