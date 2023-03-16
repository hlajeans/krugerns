package com.training.krugerns.model.repository;

import com.training.krugerns.model.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {
}
