package com.training.krugerns.model.repository;

import com.training.krugerns.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
