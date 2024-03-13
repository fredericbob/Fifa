package com.example.fifa.Services;

import com.example.fifa.Models.Club;
import com.example.fifa.Repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServices {

    private final ClubRepository clubRepository;

    public ClubServices(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> findall(){return this.clubRepository.findAll();}

    public void save(Club club){
        this.clubRepository.save(club);
    }


}
