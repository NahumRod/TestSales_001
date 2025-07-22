package com.tano.sales.producto.infrastructure.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.tano.sales.producto.infrastructure.entity.Producto;
import com.tano.sales.producto.dto.ProductoRequestDto;
import com.tano.sales.producto.dto.ProductoResponseDto;

/**
 * Mapper interface for converting between Producto entity and its DTOs.
 * Uses MapStruct to generate the implementation.
 */
@Mapper(componentModel = "spring")
public interface ProductoMapper {

    /**
     * Converts a ProductoRequestDto to a Producto entity.
     *
     * @param dto the ProductoRequestDto
     * @return the Producto entity
     */
    Producto toEntity(ProductoRequestDto dto);

    /**
     * Converts a Producto entity to a ProductoResponseDto.
     *
     * @param entity the Producto entity
     * @return the ProductoResponseDto
     */
    ProductoResponseDto toResponseDto(Producto entity);

    /**
     * Converts a list of Producto entities to a list of ProductoResponseDto.
     *
     * @param entities the list of Producto entities
     * @return the list of ProductoResponseDto
     */
    List<ProductoResponseDto> toResponseDtoList(List<Producto> entities);
}