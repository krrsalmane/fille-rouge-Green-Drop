package com.greendrop.mapper;

import com.greendrop.dto.AgriculteurDTO;
import com.greendrop.model.Agriculteur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgriculteurMapper {

    AgriculteurMapper INSTANCE = Mappers.getMapper(AgriculteurMapper.class);

    AgriculteurDTO toDto(Agriculteur agriculteur);

    @Mapping(target = "id", ignore = true) // Ignore ID for creation
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "champs", ignore = true)
    @Mapping(target = "seances", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    Agriculteur toEntity(AgriculteurDTO agriculteurDTO);

    @Mapping(target = "id", ignore = true) // ID is managed by JPA
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "champs", ignore = true)
    @Mapping(target = "seances", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    Agriculteur updateAgriculteurFromDto(AgriculteurDTO agriculteurDTO, @MappingTarget Agriculteur agriculteur);
}
