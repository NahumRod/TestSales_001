package com.tano.sales.orden.domain.ports.spi;

import com.tano.sales.orden.dto.OrdenRequestDto;
import com.tano.sales.orden.dto.OrdenResponseDto;
import com.tano.sales.orden.projection.OrdenProjection;
import com.tano.sales.orden.infrastructure.exceptions.OrdenNotFoundException;

import java.util.List;

public interface OrdenSpiPort {

    OrdenResponseDto save(OrdenRequestDto dto);

    OrdenResponseDto update(Long id, OrdenRequestDto dto) throws OrdenNotFoundException;

    OrdenProjection findById(Long id) throws OrdenNotFoundException;

    List<OrdenProjection> findAll();

    void deleteById(Long id) throws OrdenNotFoundException;

}