package com.greendrop.mapper;

import com.greendrop.dto.CultureDTO;
import com.greendrop.model.Culture;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CultureMapper {

    public abstract Culture toEntity(CultureDTO cultureDTO);

    public abstract CultureDTO toDto(Culture culture);

    public abstract void updateCultureFromDto(CultureDTO cultureDTO, @MappingTarget Culture culture);
}
