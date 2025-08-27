package com.greendrop.mapper;

import com.greendrop.dto.CultureDTO;
import com.greendrop.model.Culture;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-27T10:30:22+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class CultureMapperImpl extends CultureMapper {

    @Override
    public Culture toEntity(CultureDTO cultureDTO) {
        if ( cultureDTO == null ) {
            return null;
        }

        Culture culture = new Culture();

        culture.setId( cultureDTO.getId() );
        culture.setNom( cultureDTO.getNom() );
        culture.setBesoinsEnEau( cultureDTO.getBesoinsEnEau() );
        culture.setSaison( cultureDTO.getSaison() );

        return culture;
    }

    @Override
    public CultureDTO toDto(Culture culture) {
        if ( culture == null ) {
            return null;
        }

        CultureDTO cultureDTO = new CultureDTO();

        cultureDTO.setId( culture.getId() );
        cultureDTO.setNom( culture.getNom() );
        cultureDTO.setBesoinsEnEau( culture.getBesoinsEnEau() );
        cultureDTO.setSaison( culture.getSaison() );

        return cultureDTO;
    }

    @Override
    public void updateCultureFromDto(CultureDTO cultureDTO, Culture culture) {
        if ( cultureDTO == null ) {
            return;
        }

        culture.setId( cultureDTO.getId() );
        culture.setNom( cultureDTO.getNom() );
        culture.setBesoinsEnEau( cultureDTO.getBesoinsEnEau() );
        culture.setSaison( cultureDTO.getSaison() );
    }
}
