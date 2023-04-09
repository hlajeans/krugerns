package com.training.krugerns.controller;

import com.training.krugerns.commons.ResultResponse;
import com.training.krugerns.model.entity.Vaccination;
import com.training.krugerns.model.entity.enums.HttpMessageResponse;
import com.training.krugerns.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/vac")
public class VaccinationController {
    private final VaccinationService vaccinationService;

    @Autowired
    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @GetMapping("/findall")
    public ResponseEntity<?> findAllVaccinations() {
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpMessageResponse.FIND_SUCESS.getValue()).data(vaccinationService.findAllVaccinations()).build(), HttpStatus.OK);

    }
    @GetMapping("/finddate")
    public ResponseEntity<?> findRangeDate(@Valid @RequestBody Date init, @Valid @RequestBody Date destiny){
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpMessageResponse.FIND_SUCESS.getValue()).data(vaccinationService.findByRangeDate(init,destiny)),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")int id){
        Optional<Vaccination> vaccination = vaccinationService.findById(id);
        if(vaccination.isPresent()){
            vaccinationService.delete(vaccination.get());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpMessageResponse.DELETE_SUCESS.getValue()).build(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpMessageResponse.NOT_FOUND.getValue()).build(),HttpStatus.OK);
        }
    }
}
