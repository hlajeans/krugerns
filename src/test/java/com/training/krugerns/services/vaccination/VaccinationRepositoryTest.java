package com.training.krugerns.services.vaccination;

import com.training.krugerns.model.entity.User;
import com.training.krugerns.model.entity.Vaccination;
import com.training.krugerns.model.repository.UserRepository;
import com.training.krugerns.model.repository.VaccinationRepository;
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
class VaccinationRepositoryTest {

    @Autowired
    VaccinationRepository vaccinationRepository;
    @Test
    void findAllVaccinations() {
        List<Vaccination> list = vaccinationRepository.findAll();
        assertTrue(list.size() > 0);
    }

    @Test
    void findVaccinationExistent() {
        Optional<Vaccination> vaccination = vaccinationRepository.findById(1);
        assertTrue(vaccination.isPresent());
    }

    @Test
    void findVaccinationNotExistent() {
        Optional<Vaccination> vaccination = vaccinationRepository.findById(989898);
        assertTrue(vaccination.isEmpty());
    }
}