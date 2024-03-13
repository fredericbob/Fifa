package com.example.fifa.Services;

import com.example.fifa.Models.*;
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

    private final CoefficientService coefficientService;
    private final CaracteristiqueServices caracteristiqueServices;
    private final PosteServices posteServices;
    private final NationaliteServices nationaliteServices;

    private final ClubServices clubServices;
    private final JoueurServices joueurServices;

    @Autowired
    public ImportService(CoefficientService coefficientService, CaracteristiqueServices caracteristiqueServices, PosteServices posteServices, NationaliteServices nationaliteServices, ClubServices clubServices, JoueurServices joueurServices) {
        this.coefficientService = coefficientService;
        this.caracteristiqueServices = caracteristiqueServices;
        this.posteServices = posteServices;
        this.nationaliteServices = nationaliteServices;
        this.clubServices = clubServices;
        this.joueurServices = joueurServices;
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
    public void importcsvjoueur(MultipartFile file) throws IOException {
        try (Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVReader csvReader = new CSVReader(reader);
            String[] nextRecord;
            Club club ;
            Nationalite nationalite;
            Joueurs j;
            csvReader.readNext();

            while ((nextRecord = csvReader.readNext()) != null) {
                j = new Joueurs();

                j.setNom(nextRecord[0]);
                j.setPrenom(nextRecord[1]);
                j.setTaille(Integer.parseInt(nextRecord[2]));
                j.setAttaquant(Integer.parseInt(nextRecord[3]));
                j.setMilieu(Integer.parseInt(nextRecord[4]));
                j.setDefense(Integer.parseInt(nextRecord[5]));
                j.setGardien(Integer.parseInt(nextRecord[6]));

                nationalite =this.nationaliteServices.getbycode(nextRecord[7]);

                j.setNationalite(nationalite);
                club = this.clubServices.findbycode(nextRecord[8]);
                j.setClub(club);
                j.setPhysique(Integer.parseInt(nextRecord[9]));
                j.setVitesse(Integer.parseInt(nextRecord[10]));
                j.setPasse(Integer.parseInt(nextRecord[11]));
                j.setTir(Integer.parseInt(nextRecord[12]));
                j.setDRIBBLE(Integer.parseInt(nextRecord[13]));
                j.setDefense(Integer.parseInt(nextRecord[14]));
                this.joueurServices.save(j);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    public void importcsvcoefficient(MultipartFile file) throws IOException, CsvValidationException {
       try (Reader reader = new InputStreamReader(file.getInputStream())) {

               CSVReader csvReader = new CSVReader(reader);

               String[] nextcolonne;
               Poste p;
               Caracteristique ca;
               Coefficient c;

           csvReader.readNext();
           while ((nextcolonne = csvReader.readNext()) != null){

               c = new Coefficient();
               p = this.posteServices.findbyposte(nextcolonne[0]);
               c.setPoste(p);
               ca = this.caracteristiqueServices.findbycaracteristique(nextcolonne[1]);
               c.setCaracteristique(ca);
               c.setCoef(Integer.parseInt(nextcolonne[2]));
               this.coefficientService.save(c);

           }
           }
       }
    }

