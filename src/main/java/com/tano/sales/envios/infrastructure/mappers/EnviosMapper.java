package com.tano.sales.envios.infrastructure.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.tano.sales.envios.infrastructure.entity.Envios;
import com.tano.sales.envios.dto.EnviosRequestDto;
import com.tano.sales.envios.dto.EnviosResponseDto;

/**
 * Mapper interface for converting between Envios entity and its DTOs.
 * Uses MapStruct to generate implementation.
 */
@Mapper(componentModel = "spring")
public interface EnviosMapper {

    /**
     * Converts EnviosRequestDto to Envios entity.
     *
     * @param dto the EnviosRequestDto
     * @return the Envios entity
     */
    Envios toEntity(EnviosRequestDto dto);

    /**
     * Converts Envios entity to EnviosResponseDto.
     *
     * @param entity the Envios entity
     * @return the EnviosResponseDto
     */
    EnviosResponseDto toResponseDto(Envios entity);

    /**
     * Converts a list of Envios entities to a list of EnviosResponseDto.
     *
     * @param entities the list of Envios entities
     * @return the list of EnviosResponseDto
     */
    List<EnviosResponseDto> toResponseDtoList(List<Envios> entities);
}