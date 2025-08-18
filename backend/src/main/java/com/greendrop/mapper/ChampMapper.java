package com.greendrop.mapper;

import com.greendrop.mapper.EntityMappingResolver;
import com.greendrop.dto.ChampDTO;
import com.greendrop.model.Champ;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {EntityMappingResolver.class})
public interface ChampMapper {

    @Mapping(target = "agriculteur", source = "agriculteurId", qualifiedByName = "mapAgriculteur")
    @Mapping(target = "culture", source = "cultureId", qualifiedByName = "mapCulture")
    public abstract Champ toEntity(ChampDTO champDTO);

    @Mapping(target = "agriculteurId", source = "agriculteur.id")
    @Mapping(target = "cultureId", source = "culture.id")
    public abstract ChampDTO toDto(Champ champ);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "agriculteur", source = "agriculteurId", qualifiedByName = "mapAgriculteur")
    @Mapping(target = "culture", source = "cultureId", qualifiedByName = "mapCulture")
    public abstract void updateChampFromDto(ChampDTO champDTO, @MappingTarget Champ champ);
}
