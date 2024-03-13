package com.example.fifa.Services;

import com.example.fifa.Models.Coefficient;
import com.example.fifa.Models.Poste;
import com.example.fifa.Repository.CoefficientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoefficientService {


    private final CoefficientRepository coefficientRepository;

    @Autowired
    public CoefficientService(CoefficientRepository coefficientRepository) {
        this.coefficientRepository = coefficientRepository;
    }

    public List<Coefficient> findall(){return this.coefficientRepository.findAll();}

    public void save(Coefficient coefficient){this.coefficientRepository.save(coefficient);}

}
