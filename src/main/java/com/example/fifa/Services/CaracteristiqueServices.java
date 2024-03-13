package com.example.fifa.Services;

import com.example.fifa.Models.Caracteristique;
import com.example.fifa.Repository.CaracteristiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristiqueServices {

    private final CaracteristiqueRepository caracteristiqueRepository;

    @Autowired
    public CaracteristiqueServices(CaracteristiqueRepository caracteristiqueRepository) {
        this.caracteristiqueRepository = caracteristiqueRepository;
    }

    public List<Caracteristique> findAll(){return  this.caracteristiqueRepository.findAll();}

    public Caracteristique findbycaracteristique(String caracteristique){
        return this.caracteristiqueRepository.getbycaracteristique(caracteristique);
    }
}
