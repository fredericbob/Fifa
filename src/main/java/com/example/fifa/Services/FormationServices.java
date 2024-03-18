package com.example.fifa.Services;

import com.example.fifa.Models.Formation;
import com.example.fifa.Repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationServices {

    private final FormationRepository formationRepository;

    @Autowired
    public FormationServices(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public List<Formation> findAll(){ return this.formationRepository.findAll();}

    public Optional<Formation> findbyid(int id){ return this.formationRepository.findById(id);}

    public void save (Formation formation){this.formationRepository.save(formation);}

    public void update (int id, Formation formation){
        formation.setId(id);
        this.formationRepository.save(formation);
    }

    public void delete(int id){
        this.formationRepository.deleteById(id);
    }
}
