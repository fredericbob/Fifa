package com.example.fifa.Models;

import jakarta.persistence.*;

@Entity
public class Coefficient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "poste",referencedColumnName = "id")
    private Poste poste;

    @ManyToOne
    @JoinColumn(name = "caracteristique",referencedColumnName = "id")
    private Caracteristique caracteristique;

    private int coef;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Caracteristique getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(Caracteristique caracteristique) {
        this.caracteristique = caracteristique;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }
}
