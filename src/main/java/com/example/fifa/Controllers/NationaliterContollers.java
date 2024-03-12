package com.example.fifa.Controllers;

import com.example.fifa.Services.ImportNationalService;
import com.example.fifa.Services.NationaliteServices;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping
public class NationaliterContollers {

    private final NationaliteServices nationaliteServices;
    private final ImportNationalService importNationalService;

    @Autowired
    public NationaliterContollers(NationaliteServices nationaliteServices, ImportNationalService importNationalService) {
        this.nationaliteServices = nationaliteServices;
        this.importNationalService = importNationalService;
    }

    @PostMapping("/importnationalite")
    public ResponseEntity<String> importNationalite(@RequestParam("file") MultipartFile file) {
        try {
            importNationalService.importcsv(file);
            return ResponseEntity.ok().body("Importation réussie !");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'importation du fichier : " + e.getMessage());
        }
    }
}
