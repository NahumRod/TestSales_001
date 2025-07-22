package com.tano.sales.envios.infrastructure.adapters;

import com.tano.sales.envios.domain.ports.spi.EnviosSpiPort;
import com.tano.sales.envios.dto.EnviosRequestDto;
import com.tano.sales.envios.dto.EnviosResponseDto;
import com.tano.sales.envios.infrastructure.entity.Envios;
import com.tano.sales.envios.infrastructure.mappers.EnviosMapper;
import com.tano.sales.envios.infrastructure.repository.EnviosRepository;
import com.tano.sales.envios.projection.EnviosProjection;
import com.tano.sales.envios.infrastructure.exceptions.EnviosNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * SPI Adapter implementation for Envios entity.
 * Handles persistence operations using EnviosRepository and EnviosMapper.
 */
public class EnviosSpiAdapter implements EnviosSpiPort {

    private final EnviosRepository enviosRepository;
    private final EnviosMapper enviosMapper;

    /**
     * Constructor for EnviosSpiAdapter.
     *
     * @param enviosRepository repository for Envios entity
     * @param enviosMapper mapper for Envios entity and DTOs
     */
    public EnviosSpiAdapter(EnviosRepository enviosRepository, EnviosMapper enviosMapper) {
        this.enviosRepository = enviosRepository;
        this.enviosMapper = enviosMapper;
    }

    /**
     * Saves a new Envios entity.
     *
     * @param dto the EnviosRequestDto containing data to save
     * @return EnviosResponseDto representing the saved entity
     */
    @Override
    @Transactional
    public EnviosResponseDto save(EnviosRequestDto dto) {
        Envios entity = enviosMapper.toEntity(dto);
        Envios saved = enviosRepository.save(entity);
        return enviosMapper.toResponseDto(saved);
    }

    /**
     * Updates an existing Envios entity by id.
     *
     * @param id the primary key of the Envios entity to update
     * @param dto the EnviosRequestDto containing updated data
     * @return EnviosResponseDto representing the updated entity
     * @throws EnviosNotFoundException if the entity with given id does not exist
     */
    @Override
    @Transactional
    public EnviosResponseDto update(Long id, EnviosRequestDto dto) throws EnviosNotFoundException {
        if (!enviosRepository.existsById(id)) {
            throw new EnviosNotFoundException("Envios not found with id: " + id);
        }
        Envios entity = enviosMapper.toEntity(dto);
        entity.setEnvioId(id);
        Envios updated = enviosRepository.save(entity);
        return enviosMapper.toResponseDto(updated);
    }

    /**
     * Finds an Envios entity projection by id.
     *
     * @param id the primary key of the Envios entity
     * @return EnviosProjection projection of the found entity
     * @throws EnviosNotFoundException if the entity with given id does not exist
     */
    @Override
    public EnviosProjection findById(Long id) throws EnviosNotFoundException {
        Optional<EnviosProjection> optionalProjection = enviosRepository.findProjectionById(id);
        return optionalProjection.orElseThrow(() -> new EnviosNotFoundException("Envios not found with id: " + id));
    }

    /**
     * Finds all Envios entity projections.
     *
     * @return list of EnviosProjection
     */
    @Override
    public List<EnviosProjection> findAll() {
        return enviosRepository.findAllProjections();
    }

    /**
     * Deletes an Envios entity by id.
     *
     * @param id the primary key of the Envios entity to delete
     * @throws EnviosNotFoundException if the entity with given id does not exist
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws EnviosNotFoundException {
        if (!enviosRepository.existsById(id)) {
            throw new EnviosNotFoundException("Envios not found with id: " + id);
        }
        enviosRepository.deleteById(id);
    }
}