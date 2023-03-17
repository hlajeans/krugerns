package com.training.krugerns.model.repository;

import com.training.krugerns.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT *\n" +
            "FROM usuario \n" +
            "WHERE ci = :ci", nativeQuery = true)
    Optional<User> findByCI(@Param("ci") int ci);
}
