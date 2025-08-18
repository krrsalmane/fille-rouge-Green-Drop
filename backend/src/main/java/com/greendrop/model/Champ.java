package com.greendrop.model;

import jakarta.persistence.*;



@Entity
public class Champ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float longueur;
    private Float largeur;

    @Enumerated(EnumType.STRING)
    private SoilType soilType;

    @Enumerated(EnumType.STRING)
    private ChampStatus champStatus;

    @ManyToOne
    @JoinColumn(name = "agriculteur_id", nullable = false)
    private Agriculteur agriculteur;

    @ManyToOne
    @JoinColumn(name = "culture_id")
    private Culture culture;

    // Constructors
    public Champ() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLongueur() {
        return longueur;
    }

    public void setLongueur(Float longueur) {
        this.longueur = longueur;
    }

    public Float getLargeur() {
        return largeur;
    }

    public void setLargeur(Float largeur) {
        this.largeur = largeur;
    }

    public SoilType getSoilType() {
        return soilType;
    }

    public void setSoilType(SoilType soilType) {
        this.soilType = soilType;
    }

    public ChampStatus getChampStatus() {
        return champStatus;
    }

    public void setChampStatus(ChampStatus champStatus) {
        this.champStatus = champStatus;
    }

    public Agriculteur getAgriculteur() {
        return agriculteur;
    }

    public void setAgriculteur(Agriculteur agriculteur) {
        this.agriculteur = agriculteur;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }
}
