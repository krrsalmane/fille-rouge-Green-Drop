package com.greendrop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Agriculteur extends User {

    private String telephone;

    @OneToMany(mappedBy = "agriculteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Champ> champs;

    @OneToMany(mappedBy = "agriculteur", cascade = CascadeType.ALL)
    private List<SeanceIrrigation> seances;

    // Constructors
    public Agriculteur() {
        super();
    }

    // Getters and Setters
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Champ> getChamps() {
        return champs;
    }

    public void setChamps(List<Champ> champs) {
        this.champs = champs;
    }

    public List<SeanceIrrigation> getSeances() {
        return seances;
    }

    public void setSeances(List<SeanceIrrigation> seances) {
        this.seances = seances;
    }
}