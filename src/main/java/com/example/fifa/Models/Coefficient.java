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

    private int coefficient;

}
