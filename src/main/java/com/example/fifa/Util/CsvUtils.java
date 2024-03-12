package com.example.fifa.Util;

import java.lang.reflect.Field;

public class CsvUtils {

    public static <T> T createObjectFromFields(String[] fields, Class<T> type) {
        try {
            T object = type.getDeclaredConstructor().newInstance();
            Field[] entityFields = type.getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                // Assurez-vous que le nombre de champs CSV correspond au nombre de champs de l'entité
                if (i < entityFields.length) {
                    Field field = entityFields[i];
                    field.setAccessible(true);
                    setFieldValue(object, field, fields[i]);
                } else {
                    break; // Arrêtez si le nombre de champs CSV dépasse le nombre de champs de l'entité
                }
            }
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setFieldValue(Object object, Field field, String value) throws IllegalAccessException {
        // Ajoutez une logique de conversion de type si nécessaire
        // Par exemple, si vous devez convertir la chaîne value en un type spécifique avant de l'assigner au champ
        // Vous pouvez ajouter ici la logique de conversion
        field.setAccessible(true);

        // Vérifiez le type de champ pour effectuer une conversion si nécessaire
        if (field.getType().equals(String.class)) {
            field.set(object, value);
        } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
            field.set(object, Integer.parseInt(value));
        } else if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
            field.set(object, Double.parseDouble(value));
        } else if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
            field.set(object, Boolean.parseBoolean(value));
        } else {
            // Gérer d'autres types de données si nécessaire
            throw new IllegalArgumentException("Type de champ non pris en charge : " + field.getType().getName());
        }
        field.set(object, value);
    }
}

