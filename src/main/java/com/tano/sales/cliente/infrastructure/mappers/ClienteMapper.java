package com.tano.sales.cliente.infrastructure.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.tano.sales.cliente.infrastructure.entity.Cliente;
import com.tano.sales.cliente.dto.ClienteRequestDto;
import com.tano.sales.cliente.dto.ClienteResponseDto;

/**
 * Mapper interface for converting between Cliente entity and its DTOs.
 * Uses MapStruct to generate implementation at compile time.
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper {

    /**
     * Converts a ClienteRequestDto to a Cliente entity.
     *
     * @param dto the ClienteRequestDto to convert
     * @return the corresponding Cliente entity
     */
    Cliente toEntity(ClienteRequestDto dto);

    /**
     * Converts a Cliente entity to a ClienteResponseDto.
     *
     * @param entity the Cliente entity to convert
     * @return the corresponding ClienteResponseDto
     */
    ClienteResponseDto toResponseDto(Cliente entity);

    /**
     * Converts a list of Cliente entities to a list of ClienteResponseDto.
     *
     * @param entities the list of Cliente entities to convert
     * @return the list of corresponding ClienteResponseDto
     */
    List<ClienteResponseDto> toResponseDtoList(List<Cliente> entities);
}