package com.tano.sales.cliente.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tano.sales.cliente.domain.ports.api.ClienteApiPort;
import com.tano.sales.cliente.domain.ports.spi.ClienteSpiPort;
import com.tano.sales.cliente.dto.ClienteRequestDto;
import com.tano.sales.cliente.projection.ClienteProjection;

/**
 * Service implementation for Cliente entity.
 * Acts as a bridge between the controller and the persistence SPI port.
 * Delegates all operations to the SPI port without performing any mapping.
 */
@Service
public class ClienteServiceImpl implements ClienteApiPort {

    private final ClienteSpiPort clienteSpiPort;

    /**
     * Constructor injection of the SPI port.
     *
     * @param clienteSpiPort the SPI port for Cliente persistence operations
     */
    public ClienteServiceImpl(ClienteSpiPort clienteSpiPort) {
        this.clienteSpiPort = clienteSpiPort;
    }

    /**
     * Saves a new Cliente.
     *
     * @param dto the ClienteRequestDto containing data to save
     * @return the saved Cliente as ClienteResponseDto
     */
    @Override
    public com.tano.sales.cliente.dto.ClienteResponseDto save(ClienteRequestDto dto) {
        return clienteSpiPort.save(dto);
    }

    /**
     * Updates an existing Cliente by id.
     *
     * @param id the primary key of the Cliente to update
     * @param dto the ClienteRequestDto containing updated data
     * @return the updated Cliente as ClienteResponseDto
     */
    @Override
    public com.tano.sales.cliente.dto.ClienteResponseDto update(Long id, ClienteRequestDto dto) {
        return clienteSpiPort.update(id, dto);
    }

    /**
     * Finds a Cliente by its id.
     *
     * @param id the primary key of the Cliente
     * @return the ClienteProjection projection
     */
    @Override
    public ClienteProjection findById(Long id) {
        return clienteSpiPort.findById(id);
    }

    /**
     * Finds all Clientes.
     *
     * @return list of ClienteProjection projections
     */
    @Override
    public List<ClienteProjection> findAll() {
        return clienteSpiPort.findAll();
    }

    /**
     * Deletes a Cliente by its id.
     *
     * @param id the primary key of the Cliente to delete
     */
    @Override
    public void deleteById(Long id) {
        clienteSpiPort.deleteById(id);
    }
}