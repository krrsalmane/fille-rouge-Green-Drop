package com.greendrop.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Culture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Float besoinsEnEau;
    private String saison;

    @OneToMany(mappedBy = "culture")
    private List<Champ> champs;

    // Constructors
    public Culture() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getBesoinsEnEau() {
        return besoinsEnEau;
    }

    public void setBesoinsEnEau(Float besoinsEnEau) {
        this.besoinsEnEau = besoinsEnEau;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public List<Champ> getChamps() {
        return champs;
    }

    public void setChamps(List<Champ> champs) {
        this.champs = champs;
    }
}
