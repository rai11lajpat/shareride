package com.ride.shareride.repositrory;


import org.springframework.data.repository.CrudRepository;

import com.ride.shareride.entity.User;

import java.util.Optional;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findByUserId(Long userId);
}
