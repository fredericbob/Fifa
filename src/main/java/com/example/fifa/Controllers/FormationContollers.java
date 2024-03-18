package com.example.fifa.Controllers;


import com.example.fifa.Models.Caracteristiqueformation;
import com.example.fifa.Models.Formation;
import com.example.fifa.Models.Poste;
import com.example.fifa.Services.CaracteristiqueFormationServices;
import com.example.fifa.Services.FormationServices;
import com.example.fifa.Services.PosteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping
public class FormationContollers {

    private final CaracteristiqueFormationServices caracteristiqueFormationServices;
    private final FormationServices formationServices;
    private final PosteServices posteServices;
    @Autowired
    public FormationContollers(CaracteristiqueFormationServices caracteristiqueFormationServices, FormationServices formationServices, PosteServices posteServices) {
        this.caracteristiqueFormationServices = caracteristiqueFormationServices;
        this.formationServices = formationServices;
        this.posteServices = posteServices;
    }


    public String findformation(Model model){
        List<Formation> formations = this.formationServices.findAll();
        List<Poste> postes =this.posteServices.findall();

        model.addAttribute("formation",formations);
        model.addAttribute("poste",postes);
        return "";
    }

    @PostMapping("/insertformation")
    public String insertformation(@RequestParam("formation") String formation,@RequestParam("poste") String poste,@RequestParam("nbr") String nbr){


        try {
            Caracteristiqueformation caracteristiqueformation = new Caracteristiqueformation();

            caracteristiqueformation.setFormation(new Formation(Integer.parseInt(formation)));
            caracteristiqueformation.setPoste(new Poste(Integer.parseInt(poste)));
            caracteristiqueformation.setNbr(Integer.parseInt(nbr));
            caracteristiqueFormationServices.save(caracteristiqueformation);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  "";
    }
}
