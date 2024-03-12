package com.example.fifa.Services;

import com.example.fifa.Models.Nationalite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.fifa.Repository.NationaliteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CsvImportService {

    private final NationaliteRepository nationaliteRepository;

    public CsvImportService(NationaliteRepository nationaliteRepository) {
        this.nationaliteRepository = nationaliteRepository;
    }

    public void importNationaliteCsv(MultipartFile file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Nationalite nationalite = NationaliteCsvMapper.mapToNationalite(fields);
                this.nationaliteRepository.save(nationalite);
            }
        }


    }

}


