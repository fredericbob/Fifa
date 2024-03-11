package com.example.fifa.Controllers;

import com.example.fifa.Models.Nationalite;
import com.example.fifa.Services.NationaliteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NationaliterContollers {

    private final NationaliteServices nationaliteServices;

    @Autowired
    public NationaliterContollers(NationaliteServices nationaliteServices) {
        this.nationaliteServices = nationaliteServices;
    }

    public String uptade(@RequestParam(value = "id") int id,@RequestParam(value = "nom") String nom){
        this.nationaliteServices.uptade(id,nom);
        return "admin/modifie/nationaliteri";
    }
}
