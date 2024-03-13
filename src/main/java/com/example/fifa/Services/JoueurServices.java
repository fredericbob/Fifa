package com.example.fifa.Services;

import com.example.fifa.Models.Club;
import com.example.fifa.Models.Joueurs;
import com.example.fifa.Repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoueurServices {

    private final  ClubServices clubServices;

    private final JoueurRepository joueurRepository;

    @Autowired
    public JoueurServices(ClubServices clubServices, JoueurRepository joueurRepository) {
        this.clubServices = clubServices;
        this.joueurRepository = joueurRepository;
    }

    public List<Joueurs> findAll(){return this.joueurRepository.findAll();}

    public void save(Joueurs joueurs){this.joueurRepository.save(joueurs);}


}
