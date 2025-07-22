package com.tano.sales.orden.infrastructure.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.tano.sales.orden.infrastructure.entity.Orden;
import com.tano.sales.orden.dto.OrdenRequestDto;
import com.tano.sales.orden.dto.OrdenResponseDto;

/**
 * Mapper interface for converting between Orden entity and its DTOs.
 * Uses MapStruct to generate implementation.
 */
@Mapper(componentModel = "spring")
public interface OrdenMapper {

    /**
     * Converts OrdenRequestDto to Orden entity.
     *
     * @param dto the OrdenRequestDto
     * @return the mapped Orden entity
     */
    Orden toEntity(OrdenRequestDto dto);

    /**
     * Converts Orden entity to OrdenResponseDto.
     *
     * @param entity the Orden entity
     * @return the mapped OrdenResponseDto
     */
    OrdenResponseDto toResponseDto(Orden entity);

    /**
     * Converts a list of Orden entities to a list of OrdenResponseDto.
     *
     * @param entities the list of Orden entities
     * @return the list of mapped OrdenResponseDto
     */
    List<OrdenResponseDto> toResponseDtoList(List<Orden> entities);
}