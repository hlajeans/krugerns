package com.training.krugerns.service;

import com.training.krugerns.model.entity.Role;
import com.training.krugerns.model.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findId(int id) {
    Optional<Role> role = roleRepository.findById(id);
    return role;
    }
}
