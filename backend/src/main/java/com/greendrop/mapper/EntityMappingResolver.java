package com.greendrop.mapper;

import com.greendrop.model.Champ;
import com.greendrop.repository.ChampRepository;
import org.mapstruct.Named;
import com.greendrop.model.Agriculteur;
import com.greendrop.model.Culture;
import com.greendrop.repository.AgriculteurRepository;
import com.greendrop.repository.CultureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityMappingResolver {

    @Autowired
    private AgriculteurRepository agriculteurRepository;
    @Autowired
    private CultureRepository cultureRepository;
    @Autowired
    private ChampRepository champRepository;

    @Named("mapAgriculteur")
    public Agriculteur mapAgriculteur(Long agriculteurId) {
        return agriculteurRepository.findById(agriculteurId).orElse(null);
    }

    @Named("mapCulture")
    public Culture mapCulture(Long cultureId) {
        return cultureRepository.findById(cultureId).orElse(null);
    }

    @Named("mapChamp")
    public Champ mapChamp(Long champId) {
        return champRepository.findById(champId).orElse(null);
    }
}