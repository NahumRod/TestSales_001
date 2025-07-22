package com.tano.sales.detalleorden.domain.ports.spi;

import com.tano.sales.detalleorden.dto.DetalleOrdenRequestDto;
import com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto;
import com.tano.sales.detalleorden.projection.DetalleOrdenProjection;
import com.tano.sales.detalleorden.infrastructure.exceptions.DetalleOrdenNotFoundException;

import java.util.List;

public interface DetalleOrdenSpiPort {

    DetalleOrdenResponseDto save(DetalleOrdenRequestDto dto);

    DetalleOrdenResponseDto update(Long id, DetalleOrdenRequestDto dto) throws DetalleOrdenNotFoundException;

    DetalleOrdenProjection findById(Long id) throws DetalleOrdenNotFoundException;

    List<DetalleOrdenProjection> findAll();

    void deleteById(Long id) throws DetalleOrdenNotFoundException;

}