package com.tano.sales.envios.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tano.sales.envios.domain.ports.api.EnviosApiPort;
import com.tano.sales.envios.domain.ports.spi.EnviosSpiPort;
import com.tano.sales.envios.dto.EnviosRequestDto;
import com.tano.sales.envios.dto.EnviosResponseDto;
import com.tano.sales.envios.projection.EnviosProjection;

/**
 * Service implementation for Envios entity.
 * Acts as a bridge between the controller and the persistence port (SPI).
 * Delegates all operations to the SPI port without performing mapping.
 */
@Service
public class EnviosServiceImpl implements EnviosApiPort {

    private final EnviosSpiPort enviosSpiPort;

    /**
     * Constructor injection of the SPI port.
     * @param enviosSpiPort the SPI port for Envios
     */
    public EnviosServiceImpl(EnviosSpiPort enviosSpiPort) {
        this.enviosSpiPort = enviosSpiPort;
    }

    /**
     * Saves a new Envios entity.
     * @param dto the Envios request DTO
     * @return the saved Envios response DTO
     */
    @Override
    public EnviosResponseDto save(EnviosRequestDto dto) {
        return enviosSpiPort.save(dto);
    }

    /**
     * Updates an existing Envios entity by ID.
     * @param id the ID of the Envios entity
     * @param dto the Envios request DTO with updated data
     * @return the updated Envios response DTO
     */
    @Override
    public EnviosResponseDto update(Long id, EnviosRequestDto dto) {
        return enviosSpiPort.update(id, dto);
    }

    /**
     * Finds an Envios entity by ID.
     * @param id the ID of the Envios entity
     * @return the Envios projection
     */
    @Override
    public EnviosProjection findById(Long id) {
        return enviosSpiPort.findById(id);
    }

    /**
     * Finds all Envios entities.
     * @return list of Envios projections
     */
    @Override
    public List<EnviosProjection> findAll() {
        return enviosSpiPort.findAll();
    }

    /**
     * Deletes an Envios entity by ID.
     * @param id the ID of the Envios entity
     */
    @Override
    public void deleteById(Long id) {
        enviosSpiPort.deleteById(id);
    }
}