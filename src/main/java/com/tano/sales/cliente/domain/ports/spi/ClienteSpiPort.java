package com.tano.sales.cliente.domain.ports.spi;

import com.tano.sales.cliente.dto.ClienteRequestDto;
import com.tano.sales.cliente.dto.ClienteResponseDto;
import com.tano.sales.cliente.projection.ClienteProjection;
import com.tano.sales.cliente.infrastructure.exceptions.ClienteNotFoundException;
import java.util.List;

public interface ClienteSpiPort {

    ClienteResponseDto save(ClienteRequestDto dto);

    ClienteResponseDto update(Long id, ClienteRequestDto dto) throws ClienteNotFoundException;

    ClienteProjection findById(Long id) throws ClienteNotFoundException;

    List<ClienteProjection> findAll();

    void deleteById(Long id) throws ClienteNotFoundException;
}