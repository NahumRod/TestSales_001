package com.tano.sales.orden.infrastructure.adapters;

import com.tano.sales.orden.domain.ports.spi.OrdenSpiPort;
import com.tano.sales.orden.dto.OrdenRequestDto;
import com.tano.sales.orden.dto.OrdenResponseDto;
import com.tano.sales.orden.projection.OrdenProjection;
import com.tano.sales.orden.infrastructure.entity.Orden;
import com.tano.sales.orden.infrastructure.exceptions.OrdenNotFoundException;
import com.tano.sales.orden.infrastructure.mappers.OrdenMapper;
import com.tano.sales.orden.infrastructure.repository.OrdenRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * SPI Adapter implementation for Orden entity.
 * Handles persistence operations using OrdenRepository and maps entities to DTOs and projections.
 */
public class OrdenSpiAdapter implements OrdenSpiPort {

    private final OrdenMapper ordenMapper;
    private final OrdenRepository ordenRepository;

    /**
     * Constructor injection of mapper and repository.
     *
     * @param ordenMapper the mapper to convert between entity and DTOs
     * @param ordenRepository the repository for persistence operations
     */
    public OrdenSpiAdapter(OrdenMapper ordenMapper, OrdenRepository ordenRepository) {
        this.ordenMapper = ordenMapper;
        this.ordenRepository = ordenRepository;
    }

    /**
     * Saves a new Orden entity.
     *
     * @param dto the OrdenRequestDto containing data to save
     * @return the saved OrdenResponseDto
     */
    @Override
    @Transactional
    public OrdenResponseDto save(OrdenRequestDto dto) {
        Orden entity = ordenMapper.toEntity(dto);
        Orden saved = ordenRepository.save(entity);
        return ordenMapper.toResponseDto(saved);
    }

    /**
     * Updates an existing Orden entity by id.
     *
     * @param id the id of the Orden to update
     * @param dto the OrdenRequestDto containing updated data
     * @return the updated OrdenResponseDto
     * @throws OrdenNotFoundException if the Orden with given id does not exist
     */
    @Override
    @Transactional
    public OrdenResponseDto update(Long id, OrdenRequestDto dto) throws OrdenNotFoundException {
        if (!ordenRepository.existsById(id)) {
            throw new OrdenNotFoundException("Orden not found with id: " + id);
        }
        Orden entity = ordenMapper.toEntity(dto);
        entity.setOrdenId(id);
        Orden updated = ordenRepository.save(entity);
        return ordenMapper.toResponseDto(updated);
    }

    /**
     * Finds an OrdenProjection by id.
     *
     * @param id the id of the Orden to find
     * @return the OrdenProjection
     * @throws OrdenNotFoundException if the Orden with given id does not exist
     */
    @Override
    public OrdenProjection findById(Long id) throws OrdenNotFoundException {
        Optional<OrdenProjection> optionalProjection = ordenRepository.findProjectionById(id);
        return optionalProjection.orElseThrow(() -> new OrdenNotFoundException("Orden not found with id: " + id));
    }

    /**
     * Finds all OrdenProjection entities.
     *
     * @return list of OrdenProjection
     */
    @Override
    public List<OrdenProjection> findAll() {
        return ordenRepository.findAllProjections();
    }

    /**
     * Deletes an Orden entity by id.
     *
     * @param id the id of the Orden to delete
     * @throws OrdenNotFoundException if the Orden with given id does not exist
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws OrdenNotFoundException {
        if (!ordenRepository.existsById(id)) {
            throw new OrdenNotFoundException("Orden not found with id: " + id);
        }
        ordenRepository.deleteById(id);
    }
}