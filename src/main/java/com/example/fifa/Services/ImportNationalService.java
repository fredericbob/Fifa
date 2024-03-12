package com.example.fifa.Services;

import com.example.fifa.Models.Nationalite;
import com.example.fifa.Repository.NationaliteRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class ImportNationalService {

    private final NationaliteRepository nationaliteRepository;

    @Autowired
    public ImportNationalService(NationaliteRepository nationaliteRepository) {
        this.nationaliteRepository = nationaliteRepository;
    }

    public void importcsv(MultipartFile file) throws IOException ,CsvValidationException{
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            Nationalite nationalite;

            csvReader.readNext();

            while ((nextRecord = csvReader.readNext()) != null) {
                nationalite = new Nationalite();
                nationalite.setCode(nextRecord[0]);
                nationalite.setIntitule(nextRecord[1]);
                this.nationaliteRepository.save(nationalite);
            }
        }


    }
}
