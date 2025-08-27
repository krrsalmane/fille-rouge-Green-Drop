package com.greendrop.mapper;

import com.greendrop.dto.ChampDTO;
import com.greendrop.model.Agriculteur;
import com.greendrop.model.Champ;
import com.greendrop.model.Culture;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-27T10:18:43+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class ChampMapperImpl implements ChampMapper {

    @Autowired
    private EntityMappingResolver entityMappingResolver;

    @Override
    public Champ toEntity(ChampDTO champDTO) {
        if ( champDTO == null ) {
            return null;
        }

        Champ champ = new Champ();

        champ.setAgriculteur( entityMappingResolver.mapAgriculteur( champDTO.getAgriculteurId() ) );
        champ.setCulture( entityMappingResolver.mapCulture( champDTO.getCultureId() ) );
        champ.setId( champDTO.getId() );
        champ.setLongueur( champDTO.getLongueur() );
        champ.setLargeur( champDTO.getLargeur() );
        champ.setSoilType( champDTO.getSoilType() );
        champ.setChampStatus( champDTO.getChampStatus() );

        return champ;
    }

    @Override
    public ChampDTO toDto(Champ champ) {
        if ( champ == null ) {
            return null;
        }

        ChampDTO champDTO = new ChampDTO();

        champDTO.setAgriculteurId( champAgriculteurId( champ ) );
        champDTO.setCultureId( champCultureId( champ ) );
        champDTO.setId( champ.getId() );
        champDTO.setLongueur( champ.getLongueur() );
        champDTO.setLargeur( champ.getLargeur() );
        champDTO.setSoilType( champ.getSoilType() );
        champDTO.setChampStatus( champ.getChampStatus() );

        return champDTO;
    }

    @Override
    public void updateChampFromDto(ChampDTO champDTO, Champ champ) {
        if ( champDTO == null ) {
            return;
        }

        champ.setAgriculteur( entityMappingResolver.mapAgriculteur( champDTO.getAgriculteurId() ) );
        champ.setCulture( entityMappingResolver.mapCulture( champDTO.getCultureId() ) );
        champ.setLongueur( champDTO.getLongueur() );
        champ.setLargeur( champDTO.getLargeur() );
        champ.setSoilType( champDTO.getSoilType() );
        champ.setChampStatus( champDTO.getChampStatus() );
    }

    private Long champAgriculteurId(Champ champ) {
        if ( champ == null ) {
            return null;
        }
        Agriculteur agriculteur = champ.getAgriculteur();
        if ( agriculteur == null ) {
            return null;
        }
        Long id = agriculteur.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long champCultureId(Champ champ) {
        if ( champ == null ) {
            return null;
        }
        Culture culture = champ.getCulture();
        if ( culture == null ) {
            return null;
        }
        Long id = culture.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
