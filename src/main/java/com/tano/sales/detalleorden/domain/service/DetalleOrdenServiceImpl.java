package com.tano.sales.detalleorden.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tano.sales.detalleorden.domain.ports.api.DetalleOrdenApiPort;
import com.tano.sales.detalleorden.domain.ports.spi.DetalleOrdenSpiPort;
import com.tano.sales.detalleorden.dto.DetalleOrdenRequestDto;
import com.tano.sales.detalleorden.projection.DetalleOrdenProjection;

/**
 * Service implementation for DetalleOrden.
 * Acts as a bridge between the controller and the persistence SPI port.
 * Delegates all operations to the SPI port without performing mapping.
 */
@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenApiPort {

    private final DetalleOrdenSpiPort detalleOrdenSpiPort;

    /**
     * Constructor injection of the SPI port.
     *
     * @param detalleOrdenSpiPort the SPI port for DetalleOrden
     */
    public DetalleOrdenServiceImpl(DetalleOrdenSpiPort detalleOrdenSpiPort) {
        this.detalleOrdenSpiPort = detalleOrdenSpiPort;
    }

    /**
     * Saves a new DetalleOrden.
     *
     * @param dto the DetalleOrden request DTO
     * @return the saved DetalleOrden response DTO
     */
    @Override
    public com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto save(DetalleOrdenRequestDto dto) {
        return detalleOrdenSpiPort.save(dto);
    }

    /**
     * Updates an existing DetalleOrden by id.
     *
     * @param id the id of the DetalleOrden to update
     * @param dto the DetalleOrden request DTO with updated data
     * @return the updated DetalleOrden response DTO
     */
    @Override
    public com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto update(Long id, DetalleOrdenRequestDto dto) {
        return detalleOrdenSpiPort.update(id, dto);
    }

    /**
     * Finds a DetalleOrden by id.
     *
     * @param id the id of the DetalleOrden
     * @return the DetalleOrden projection
     */
    @Override
    public DetalleOrdenProjection findById(Long id) {
        return detalleOrdenSpiPort.findById(id);
    }

    /**
     * Finds all DetalleOrden entities.
     *
     * @return list of DetalleOrden projections
     */
    @Override
    public List<DetalleOrdenProjection> findAll() {
        return detalleOrdenSpiPort.findAll();
    }

    /**
     * Deletes a DetalleOrden by id.
     *
     * @param id the id of the DetalleOrden to delete
     */
    @Override
    public void deleteById(Long id) {
        detalleOrdenSpiPort.deleteById(id);
    }
}