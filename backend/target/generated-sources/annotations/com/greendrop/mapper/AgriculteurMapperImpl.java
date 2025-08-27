package com.greendrop.mapper;

import com.greendrop.dto.AgriculteurDTO;
import com.greendrop.model.Agriculteur;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-27T10:30:22+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class AgriculteurMapperImpl implements AgriculteurMapper {

    @Override
    public AgriculteurDTO toDto(Agriculteur agriculteur) {
        if ( agriculteur == null ) {
            return null;
        }

        AgriculteurDTO agriculteurDTO = new AgriculteurDTO();

        agriculteurDTO.setId( agriculteur.getId() );
        agriculteurDTO.setNom( agriculteur.getNom() );
        agriculteurDTO.setPrenom( agriculteur.getPrenom() );
        agriculteurDTO.setEmail( agriculteur.getEmail() );
        agriculteurDTO.setTelephone( agriculteur.getTelephone() );
        agriculteurDTO.setRole( agriculteur.getRole() );

        return agriculteurDTO;
    }

    @Override
    public Agriculteur toEntity(AgriculteurDTO agriculteurDTO) {
        if ( agriculteurDTO == null ) {
            return null;
        }

        Agriculteur agriculteur = new Agriculteur();

        agriculteur.setNom( agriculteurDTO.getNom() );
        agriculteur.setPrenom( agriculteurDTO.getPrenom() );
        agriculteur.setEmail( agriculteurDTO.getEmail() );
        agriculteur.setRole( agriculteurDTO.getRole() );
        agriculteur.setTelephone( agriculteurDTO.getTelephone() );

        return agriculteur;
    }

    @Override
    public Agriculteur updateAgriculteurFromDto(AgriculteurDTO agriculteurDTO, Agriculteur agriculteur) {
        if ( agriculteurDTO == null ) {
            return agriculteur;
        }

        agriculteur.setNom( agriculteurDTO.getNom() );
        agriculteur.setPrenom( agriculteurDTO.getPrenom() );
        agriculteur.setEmail( agriculteurDTO.getEmail() );
        agriculteur.setRole( agriculteurDTO.getRole() );
        agriculteur.setTelephone( agriculteurDTO.getTelephone() );

        return agriculteur;
    }
}
