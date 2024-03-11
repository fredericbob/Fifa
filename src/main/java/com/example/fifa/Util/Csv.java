package com.example.fifa.Util;

import com.example.fifa.Models.Nationalite;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Csv {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Code", "Intitule"};
    public static boolean hasCsvFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<Nationalite> csvToStuList(InputStream is) {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(bReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Nationalite> stuList = new ArrayList<Nationalite>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Nationalite stu = new Nationalite();
                stu.setId(Integer.parseInt(csvRecord.get("Code")));
                stu.setNom(csvRecord.get("Intitule"));
                stuList.add(stu);
            }
            return stuList;
        } catch (IOException e) {
            throw new RuntimeException("CSV data is failed to parse: " + e.getMessage());
        }
        }
    }

