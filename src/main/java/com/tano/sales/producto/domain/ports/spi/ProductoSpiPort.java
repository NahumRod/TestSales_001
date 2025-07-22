package com.tano.sales.producto.domain.ports.spi;

import com.tano.sales.producto.dto.ProductoRequestDto;
import com.tano.sales.producto.dto.ProductoResponseDto;
import com.tano.sales.producto.projection.ProductoProjection;
import com.tano.sales.producto.infrastructure.exceptions.ProductoNotFoundException;
import java.util.List;

public interface ProductoSpiPort {

    ProductoResponseDto save(ProductoRequestDto dto);

    ProductoResponseDto update(Long id, ProductoRequestDto dto) throws ProductoNotFoundException;

    ProductoProjection findById(Long id) throws ProductoNotFoundException;

    List<ProductoProjection> findAll();

    void deleteById(Long id) throws ProductoNotFoundException;

}