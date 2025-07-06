package com.greendrop.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class SeanceIrrigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime heure;
    private Float quantiteEau;

    @ManyToOne
    @JoinColumn(name = "champ_id", nullable = false)
    private Champ champ;

    @ManyToOne
    @JoinColumn(name = "agriculteur_id", nullable = false)
    private Agriculteur agriculteur;

    // Constructors
    public SeanceIrrigation() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public Float getQuantiteEau() {
        return quantiteEau;
    }

    public void setQuantiteEau(Float quantiteEau) {
        this.quantiteEau = quantiteEau;
    }

    public Champ getChamp() {
        return champ;
    }

    public void setChamp(Champ champ) {
        this.champ = champ;
    }

    public Agriculteur getAgriculteur() {
        return agriculteur;
    }

    public void setAgriculteur(Agriculteur agriculteur) {
        this.agriculteur = agriculteur;
    }
}