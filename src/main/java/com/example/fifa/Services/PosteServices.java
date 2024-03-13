package com.example.fifa.Services;

import com.example.fifa.Models.Poste;
import com.example.fifa.Repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteServices {

    private final PosteRepository posteRepository;

    @Autowired
    public PosteServices(PosteRepository posteRepository) {
        this.posteRepository = posteRepository;
    }

    public List<Poste> findall(){
        return this.posteRepository.findAll();
    }

    public Poste findbyposte(String poste){
        return this.posteRepository.getbyposte(poste);
    }
}
