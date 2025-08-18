package com.greendrop.mapper;

import com.greendrop.dto.SeanceIrrigationDTO;
import com.greendrop.model.Agriculteur;
import com.greendrop.model.Champ;
import com.greendrop.model.SeanceIrrigation;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-18T15:33:18+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class SeanceIrrigationMapperImpl extends SeanceIrrigationMapper {

    @Autowired
    private EntityMappingResolver entityMappingResolver;

    @Override
    public SeanceIrrigation toEntity(SeanceIrrigationDTO seanceIrrigationDTO) {
        if ( seanceIrrigationDTO == null ) {
            return null;
        }

        SeanceIrrigation seanceIrrigation = new SeanceIrrigation();

        seanceIrrigation.setChamp( entityMappingResolver.mapChamp( seanceIrrigationDTO.getChampId() ) );
        seanceIrrigation.setAgriculteur( entityMappingResolver.mapAgriculteur( seanceIrrigationDTO.getAgriculteurId() ) );
        seanceIrrigation.setId( seanceIrrigationDTO.getId() );
        seanceIrrigation.setDate( seanceIrrigationDTO.getDate() );
        seanceIrrigation.setHeure( seanceIrrigationDTO.getHeure() );
        seanceIrrigation.setQuantiteEau( seanceIrrigationDTO.getQuantiteEau() );

        return seanceIrrigation;
    }

    @Override
    public SeanceIrrigationDTO toDto(SeanceIrrigation seanceIrrigation) {
        if ( seanceIrrigation == null ) {
            return null;
        }

        SeanceIrrigationDTO seanceIrrigationDTO = new SeanceIrrigationDTO();

        seanceIrrigationDTO.setChampId( seanceIrrigationChampId( seanceIrrigation ) );
        seanceIrrigationDTO.setAgriculteurId( seanceIrrigationAgriculteurId( seanceIrrigation ) );
        seanceIrrigationDTO.setId( seanceIrrigation.getId() );
        seanceIrrigationDTO.setDate( seanceIrrigation.getDate() );
        seanceIrrigationDTO.setHeure( seanceIrrigation.getHeure() );
        seanceIrrigationDTO.setQuantiteEau( seanceIrrigation.getQuantiteEau() );

        return seanceIrrigationDTO;
    }

    @Override
    public void updateSeanceIrrigationFromDto(SeanceIrrigationDTO seanceIrrigationDTO, SeanceIrrigation seanceIrrigation) {
        if ( seanceIrrigationDTO == null ) {
            return;
        }

        seanceIrrigation.setChamp( entityMappingResolver.mapChamp( seanceIrrigationDTO.getChampId() ) );
        seanceIrrigation.setAgriculteur( entityMappingResolver.mapAgriculteur( seanceIrrigationDTO.getAgriculteurId() ) );
        seanceIrrigation.setDate( seanceIrrigationDTO.getDate() );
        seanceIrrigation.setHeure( seanceIrrigationDTO.getHeure() );
        seanceIrrigation.setQuantiteEau( seanceIrrigationDTO.getQuantiteEau() );
    }

    private Long seanceIrrigationChampId(SeanceIrrigation seanceIrrigation) {
        if ( seanceIrrigation == null ) {
            return null;
        }
        Champ champ = seanceIrrigation.getChamp();
        if ( champ == null ) {
            return null;
        }
        Long id = champ.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long seanceIrrigationAgriculteurId(SeanceIrrigation seanceIrrigation) {
        if ( seanceIrrigation == null ) {
            return null;
        }
        Agriculteur agriculteur = seanceIrrigation.getAgriculteur();
        if ( agriculteur == null ) {
            return null;
        }
        Long id = agriculteur.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
