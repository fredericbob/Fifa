package com.example.fifa.Models;

import jakarta.persistence.*;

@Entity
public class Caracteristiqueformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idformation" ,referencedColumnName = "id")
    private Formation formation;

    @ManyToOne
    @JoinColumn(name = "idposte" ,referencedColumnName = "id")
    private Poste poste;
    private int nbr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
}
