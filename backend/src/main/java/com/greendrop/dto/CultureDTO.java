package com.greendrop.dto;



public class CultureDTO {
    private Long id;
    private String nom;
    private Float besoinsEnEau;
    private String saison;

    // Constructors
    public CultureDTO() {
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
}
