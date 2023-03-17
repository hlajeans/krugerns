package com.training.krugerns.service;

import com.training.krugerns.model.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findId(int id);

}
