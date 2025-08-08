package com.greendrop.dto;
import com.greendrop.model.ChampStatus;
import com.greendrop.model.SoilType;




public class ChampDTO {
    private Long id;
    private Float longueur;
    private Float largeur;
    private SoilType soilType;
    private ChampStatus champStatus;
    private Long agriculteurId;
    private Long cultureId;


    public ChampDTO() {
    }


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

    public Long getAgriculteurId() {
        return agriculteurId;
    }

    public void setAgriculteurId(Long agriculteurId) {
        this.agriculteurId = agriculteurId;
    }

    public Long getCultureId() {
        return cultureId;
    }

    public void setCultureId(Long cultureId) {
        this.cultureId = cultureId;
    }
}