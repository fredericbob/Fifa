package com.example.fifa.Models;

import jakarta.persistence.*;

@Entity
public class Joueurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private int taille;
    private int attaquant;
    private int milieu;
    private int defensseur;
    private int gardien;
    @ManyToOne
    @JoinColumn(name = "idnationalite" ,referencedColumnName = "id")
    private Nationalite nationalite;

    @ManyToOne
    @JoinColumn(name = "idclub" ,referencedColumnName = "id")
    private Club club;

    private int physique;
    private int vitesse;
    private int passe;
    private int tir;
    private int dribble;
    private int defense;
}
