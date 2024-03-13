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
    @JoinColumn(name = "nationalite" ,referencedColumnName = "id")
    private Nationalite nationalite;

    @ManyToOne
    @JoinColumn(name = "club" ,referencedColumnName = "id")
    private Club club;

    private int physique;
    private int vitesse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getAttaquant() {
        return attaquant;
    }

    public void setAttaquant(int attaquant) {
        this.attaquant = attaquant;
    }

    public int getMilieu() {
        return milieu;
    }

    public void setMilieu(int milieu) {
        this.milieu = milieu;
    }

    public int getDefensseur() {
        return defensseur;
    }

    public void setDefensseur(int defensseur) {
        this.defensseur = defensseur;
    }

    public int getGardien() {
        return gardien;
    }

    public void setGardien(int gardien) {
        this.gardien = gardien;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public int getPhysique() {
        return physique;
    }

    public void setPhysique(int physique) {
        this.physique = physique;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public int getTir() {
        return tir;
    }

    public void setTir(int tir) {
        this.tir = tir;
    }

    public int getDribble() {
        return dribble;
    }

    public void setDribble(int dribble) {
        this.dribble = dribble;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    private int passe;
    private int tir;
    private int dribble;
    private int defense;
}
