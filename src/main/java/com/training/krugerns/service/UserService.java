package com.training.krugerns.service;

import com.training.krugerns.model.entity.User;
import com.training.krugerns.model.pojos.dto.UserDTO;
import com.training.krugerns.model.pojos.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {


    UserVO persist(UserDTO dto);
    Page<User> findAll(Pageable pageable);
    Optional<User> findByCI(int ci);
    Optional<User> findById(int id);
    void update (User user);
    void delete(User user);
}
