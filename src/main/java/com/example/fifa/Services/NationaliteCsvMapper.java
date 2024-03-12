package com.example.fifa.Services;

import com.example.fifa.Models.Nationalite;

public class NationaliteCsvMapper {

    public static Nationalite mapToNationalite(String[] csvFields) {
        Nationalite nationalite = new Nationalite();

        for (int i = 0; i < csvFields.length; i++) {
            switch (i) {
                case 0:
                    nationalite.setCode(csvFields[i]);
                    break;
                case 1:
                    nationalite.setIntitule(csvFields[i]);
                    break;
                default:
                    // Gérer d'autres champs si nécessaire
                    break;

            }


        }

        return nationalite;
    }
}

