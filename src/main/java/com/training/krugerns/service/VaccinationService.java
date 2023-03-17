package com.training.krugerns.service;

import com.training.krugerns.model.entity.User;
import com.training.krugerns.model.entity.Vaccination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VaccinationService {

    Page<Vaccination> findAll(Pageable pageable);
    Optional<Vaccination> findById(int id);
    void delete(Vaccination vaccination);

    List<Vaccination> findAllVaccinations();
}
