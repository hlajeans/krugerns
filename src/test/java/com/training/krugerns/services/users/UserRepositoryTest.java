package com.training.krugerns.services.users;

import com.training.krugerns.model.entity.User;
import com.training.krugerns.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Test
    void findAllUsers() {
        List<User> list = userRepository.findAll();
        assertTrue(list.size() > 0);
    }

    @Test
    void findPersonExistent() {
        Optional<User> user = userRepository.findById(1);
        assertTrue(user.isPresent());
    }

    @Test
    void findPersonNotExistent() {
        Optional<User> user = userRepository.findById(989898);
        assertTrue(user.isEmpty());
    }
}