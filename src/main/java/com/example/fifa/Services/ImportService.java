package com.example.fifa.Services;

import com.example.fifa.Models.Club;
import com.example.fifa.Models.Nationalite;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class ImportService {

    private final NationaliteServices nationaliteServices;

    private final ClubServices clubServices;

    @Autowired
    public ImportService(NationaliteServices nationaliteServices, ClubServices clubServices) {
        this.nationaliteServices = nationaliteServices;
        this.clubServices = clubServices;
    }

    @Transactional
    public void importcsvnational(MultipartFile file) throws IOException ,CsvValidationException{
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            Nationalite nationalite;

            csvReader.readNext();

            while ((nextRecord = csvReader.readNext()) != null) {
                nationalite = new Nationalite();
                nationalite.setCode(nextRecord[0]);
                nationalite.setIntitule(nextRecord[1]);
                this.nationaliteServices.save(nationalite);
            }
        }
    }

    @Transactional
    public void importcsvclub(MultipartFile file) throws IOException {
      try(  Reader reader = new InputStreamReader(file.getInputStream())){
            CSVReader csvReader= new CSVReader(reader);
            String[] nextRecord ;
            Club club;

            csvReader.readNext();

            while((nextRecord =csvReader.readNext()) !=null){
                club = new Club();
                club.setCode_club(nextRecord[0]);
                club.setIntitule((nextRecord[1]));
                this.clubServices.save(club);
            }
        } catch (CsvValidationException e) {
          throw new RuntimeException(e);
      }
    }



}
