package com.greendrop.dto;


import java.time.LocalDate;
import java.time.LocalTime;

public class SeanceIrrigationDTO {
    private Long id;
    private LocalDate date;
    private LocalTime heure;
    private Float quantiteEau;
    private Long champId;
    private Long agriculteurId;

    // Constructors
    public SeanceIrrigationDTO() {
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

    public Long getChampId() {
        return champId;
    }

    public void setChampId(Long champId) {
        this.champId = champId;
    }

    public Long getAgriculteurId() {
        return agriculteurId;
    }

    public void setAgriculteurId(Long agriculteurId) {
        this.agriculteurId = agriculteurId;
    }
}
