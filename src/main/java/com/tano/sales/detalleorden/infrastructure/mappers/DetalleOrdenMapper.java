package com.tano.sales.detalleorden.infrastructure.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.tano.sales.detalleorden.infrastructure.entity.DetalleOrden;
import com.tano.sales.detalleorden.dto.DetalleOrdenRequestDto;
import com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto;

/**
 * Mapper interface for converting between DetalleOrden entity and its DTOs.
 * Uses MapStruct to generate implementation.
 */
@Mapper(componentModel = "spring")
public interface DetalleOrdenMapper {

    /**
     * Converts a DetalleOrdenRequestDto to a DetalleOrden entity.
     *
     * @param dto the DetalleOrdenRequestDto
     * @return the DetalleOrden entity
     */
    DetalleOrden toEntity(DetalleOrdenRequestDto dto);

    /**
     * Converts a DetalleOrden entity to a DetalleOrdenResponseDto.
     *
     * @param entity the DetalleOrden entity
     * @return the DetalleOrdenResponseDto
     */
    DetalleOrdenResponseDto toResponseDto(DetalleOrden entity);

    /**
     * Converts a list of DetalleOrden entities to a list of DetalleOrdenResponseDto.
     *
     * @param entities the list of DetalleOrden entities
     * @return the list of DetalleOrdenResponseDto
     */
    List<DetalleOrdenResponseDto> toResponseDtoList(List<DetalleOrden> entities);
}