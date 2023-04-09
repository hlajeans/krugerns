package com.training.krugerns.service;

import com.training.krugerns.model.entity.Role;
import com.training.krugerns.model.entity.User;
import com.training.krugerns.model.pojos.dto.UserDTO;
import com.training.krugerns.model.pojos.vo.UserVO;
import com.training.krugerns.model.repository.RoleRepository;
import com.training.krugerns.model.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserVO persist(UserDTO dto) {
        User entity = new User();
        entity.setCi(dto.getCi());
        entity.setLastName(dto.getLastName());
        entity.setNames(dto.getNames());
        entity.setEmail(dto.getEmail());
        Optional<Role> role = roleRepository.findById(dto.getIdRole());
        if(role.isPresent()) {
            entity.setRole(role.get());
        }

         return entityToVO(userRepository.save(entity));
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findByCI(int ci) {
        Optional<User> user = userRepository.findByCI(ci);
        return user;
    }


    @Override
    public Optional<User> findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
     userRepository.delete(user);
    }

    private UserVO entityToVO(User entity){
        UserVO user = new UserVO();
        BeanUtils.copyProperties(entity, user);
        user.setRole(entity.getRole().getName());
        return user;
    }
}
