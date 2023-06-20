package com.tunadag.mapper;

import com.tunadag.dto.request.BeerCreateRequestDto;
import com.tunadag.dto.request.WineCreateRequestDto;
import com.tunadag.repositories.entity.Beer;
import com.tunadag.repositories.entity.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper((ProductMapper.class));
    Wine toWine(final WineCreateRequestDto dto);
    Beer toBeer(final BeerCreateRequestDto dto);
}
