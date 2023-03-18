package com.training.krugerns.service;

import com.training.krugerns.model.entity.Vaccination;
import com.training.krugerns.model.repository.VaccinationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationServiceImp implements VaccinationService{
    private final VaccinationRepository vaccinationRepository;

    public VaccinationServiceImp(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    @Override
    public Page<Vaccination> findAll(Pageable pageable) {
        return vaccinationRepository.findAll(pageable);
    }

    @Override
    public Optional<Vaccination> findById(int id) {
        Optional<Vaccination> vaccination = vaccinationRepository.findById(id);
        return vaccination;
    }

    @Override
    public void delete(Vaccination vaccination) {
        vaccinationRepository.delete(vaccination);
    }

    @Override
    public List<Vaccination> findAllVaccinations() {
        List<Vaccination> vaccinations = vaccinationRepository.findAllVaccinations();
        return vaccinations;
    }

    @Override
    public List<Vaccination> findByRangeDate(Date initial, Date destiny) {
        List<Vaccination> vaccinations;
        if(initial.before(destiny)){
            vaccinations = vaccinationRepository.findByRangeDate(initial, destiny);
        }else{
            vaccinations = null;
        }
        return vaccinations;
    }
}
