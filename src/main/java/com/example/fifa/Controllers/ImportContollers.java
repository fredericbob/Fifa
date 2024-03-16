package com.example.fifa.Controllers;

import com.example.fifa.Models.Nationalite;
import com.example.fifa.Services.ImportService;
import com.example.fifa.Services.NationaliteServices;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping
public class ImportContollers {

    private final NationaliteServices nationaliteServices;
    private final ImportService importService;

    @Autowired
    public ImportContollers(NationaliteServices nationaliteServices, ImportService importService) {
        this.nationaliteServices = nationaliteServices;
        this.importService = importService;
    }

    @GetMapping("/abc")
    public String index() {
        return "index2";
    }

    @PostMapping("/importnationalite")
    public ResponseEntity<String> importNationalite(@RequestParam("file") MultipartFile file,@RequestParam("types") String type) {
        try {
            if("nationalite".equals(type) ) {
                importService.importcsvnational(file);
            } else if ("club".equals(type)) {
                importService.importcsvclub(file);
            }
            else if ("joueurs".equals(type)) {
                importService.importcsvjoueur(file);
            }
            else if ("coef".equals(type)) {
                importService.importcsvcoefficient(file);
            }

            return ResponseEntity.ok().body("Importation réussie !");
        } catch (Exception e) {
            System.out.println(            e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'importation du fichier : " + e.getMessage());
        }
    }
}
