package com.example.fifa.Models;

import java.util.HashMap;
import java.util.Objects;

public class Values {
    private static final HashMap<String, String[]> dataCsv;

    static {
        dataCsv = new HashMap<>();
        dataCsv.put("joueurs", new String[]{"nom", "prenom", "taille","attaquant","milieu","defenseur","gardien","nationalite","club","physique","vitesse","passe","tir","dribble","defense"});
        dataCsv.put("club", new String[]{"code_club", "intitule"});
        dataCsv.put("nationalite", new String[]{"code","Intitule"});
        dataCsv.put("coefficient", new String[]{"Poste","Caracteristique","coef"});
    }

    public static boolean isEqual(String fileKey, String[] headers) {
        String[] headers_true = dataCsv.get(fileKey);
        if (headers_true.length != headers.length) return false;

        for (int i=0; i < headers.length; i++) {
            if (!headers_true[i].equalsIgnoreCase(headers[i])) return false;
        }
        return true;
    }
}
