package com.training.krugerns.service;

import com.training.krugerns.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    Page<User> findAll(Pageable pageable);
    Optional<User> findById(int id);
    void update (User user);
    void delete(User user);
}
