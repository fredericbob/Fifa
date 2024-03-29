package com.example.fifa.Services;

import com.example.fifa.Models.Nationalite;
import com.example.fifa.Repository.NationaliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationaliteServices {

    private final NationaliteRepository nationaliteRepository;

    @Autowired
    public NationaliteServices(NationaliteRepository nationaliteRepository) {
        this.nationaliteRepository = nationaliteRepository;
    }

    public List<Nationalite> findAll(){ return this.nationaliteRepository.findAll();}

    public void save(Nationalite nationalite){
        this.nationaliteRepository.save(nationalite);
    }

    public Nationalite getbycode(String code){
      return   this.nationaliteRepository.getbycode(code);
    }
}
