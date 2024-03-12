package com.example.fifa.Controllers;


import com.example.fifa.Models.Nationalite;
import com.example.fifa.Services.CsvImportService;
import java.io.IOException;
import java.util.List;

import com.example.fifa.Services.NationaliteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CsvImportController {


    @Autowired
    private CsvImportService csvImportService;


    @PostMapping("/import/nationalite")
    public ResponseEntity<String> importNationaliteCsv(@RequestParam("file") MultipartFile file) {
        try {
       csvImportService.importNationaliteCsv(file);

            // Vous pouvez ajouter une logique supplémentaire ici, par exemple, sauvegarder les données importées dans la base de données
            return ResponseEntity.ok("Importation réussie des nationalités.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'importation des nationalités.");
        }
    }


    }

