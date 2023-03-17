package com.training.krugerns.model.repository;

import com.training.krugerns.model.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {

    @Query(value = "select va.id_vacunacion, fecha, dosis, u.nombres, v.nombre\n" +
            "from vacunacion va\n" +
            "JOIN vacuna v on v.id_vacuna = va.id_vacuna\n" +
            "JOIN usuario u on u.id_usuario = va.id_usuario", nativeQuery = true)
    List<Vaccination> findAllVaccinations();

}
