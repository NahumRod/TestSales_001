package com.tano.sales.orden.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tano.sales.orden.domain.ports.api.OrdenApiPort;
import com.tano.sales.orden.domain.ports.spi.OrdenSpiPort;
import com.tano.sales.orden.dto.OrdenRequestDto;
import com.tano.sales.orden.projection.OrdenProjection;

/**
 * Service implementation for Orden entity.
 * Acts as a bridge between the controller and the persistence SPI port.
 * Delegates all operations to the SPI port without performing any mapping.
 */
@Service
public class OrdenServiceImpl implements OrdenApiPort {

    private final OrdenSpiPort ordenSpiPort;

    public OrdenServiceImpl(OrdenSpiPort ordenSpiPort) {
        this.ordenSpiPort = ordenSpiPort;
    }

    /**
     * Saves a new Orden.
     * @param dto the Orden request DTO
     * @return the saved Orden projection
     */
    @Override
    public OrdenProjection save(OrdenRequestDto dto) {
        return ordenSpiPort.save(dto);
    }

    /**
     * Updates an existing Orden by id.
     * @param id the primary key of the Orden
     * @param dto the Orden request DTO with updated data
     * @return the updated Orden projection
     */
    @Override
    public OrdenProjection update(Long id, OrdenRequestDto dto) {
        return ordenSpiPort.update(id, dto);
    }

    /**
     * Finds an Orden by its id.
     * @param id the primary key of the Orden
     * @return the found Orden projection
     */
    @Override
    public OrdenProjection findById(Long id) {
        return ordenSpiPort.findById(id);
    }

    /**
     * Finds all Orden entities.
     * @return list of Orden projections
     */
    @Override
    public List<OrdenProjection> findAll() {
        return ordenSpiPort.findAll();
    }

    /**
     * Deletes an Orden by its id.
     * @param id the primary key of the Orden
     */
    @Override
    public void deleteById(Long id) {
        ordenSpiPort.deleteById(id);
    }
}