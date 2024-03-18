package com.example.fifa.Services;


import com.example.fifa.Models.Caracteristiqueformation;
import com.example.fifa.Repository.CaracteristiqueformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristiqueFormationServices {


    private final CaracteristiqueformationRepository caracteristiqueformationRepository;

    @Autowired
    public CaracteristiqueFormationServices(CaracteristiqueformationRepository caracteristiqueformationRepository) {
        this.caracteristiqueformationRepository = caracteristiqueformationRepository;
    }

    public List<Caracteristiqueformation> findall(){return this.caracteristiqueformationRepository.findAll();}

    public Optional<Caracteristiqueformation> findbyid(int id){ return this.caracteristiqueformationRepository.findById(id);}

    public void save(Caracteristiqueformation caracteristiqueformation){ this.caracteristiqueformationRepository.save(caracteristiqueformation);}
}
