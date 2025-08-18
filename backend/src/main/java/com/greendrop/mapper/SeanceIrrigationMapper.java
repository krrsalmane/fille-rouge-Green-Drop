package com.greendrop.mapper;

import com.greendrop.dto.SeanceIrrigationDTO;
import com.greendrop.model.SeanceIrrigation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {EntityMappingResolver.class})
public abstract class SeanceIrrigationMapper {

    @Mapping(target = "champ", source = "champId", qualifiedByName = "mapChamp")
    @Mapping(target = "agriculteur", source = "agriculteurId", qualifiedByName = "mapAgriculteur")
    public abstract SeanceIrrigation toEntity(SeanceIrrigationDTO seanceIrrigationDTO);

    @Mapping(target = "champId", source = "champ.id")
    @Mapping(target = "agriculteurId", source = "agriculteur.id")
    public abstract SeanceIrrigationDTO toDto(SeanceIrrigation seanceIrrigation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "champ", source = "champId", qualifiedByName = "mapChamp")
    @Mapping(target = "agriculteur", source = "agriculteurId", qualifiedByName = "mapAgriculteur")
    public abstract void updateSeanceIrrigationFromDto(SeanceIrrigationDTO seanceIrrigationDTO, @MappingTarget SeanceIrrigation seanceIrrigation);
}
