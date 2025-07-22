package com.tano.sales.detalleorden.infrastructure.adapters;

import com.tano.sales.detalleorden.domain.ports.spi.DetalleOrdenSpiPort;
import com.tano.sales.detalleorden.dto.DetalleOrdenRequestDto;
import com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto;
import com.tano.sales.detalleorden.infrastructure.mappers.DetalleOrdenMapper;
import com.tano.sales.detalleorden.infrastructure.repository.DetalleOrdenRepository;
import com.tano.sales.detalleorden.projection.DetalleOrdenProjection;
import com.tano.sales.detalleorden.infrastructure.exceptions.DetalleOrdenNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SPI Adapter implementation for DetalleOrden entity.
 * Handles persistence operations using repository and mapper.
 */
public class DetalleOrdenSpiAdapter implements DetalleOrdenSpiPort {

    private final DetalleOrdenRepository detalleOrdenRepository;
    private final DetalleOrdenMapper detalleOrdenMapper;

    /**
     * Constructor injection of repository and mapper.
     *
     * @param detalleOrdenRepository repository for DetalleOrden
     * @param detalleOrdenMapper mapper for DetalleOrden
     */
    public DetalleOrdenSpiAdapter(DetalleOrdenRepository detalleOrdenRepository, DetalleOrdenMapper detalleOrdenMapper) {
        this.detalleOrdenRepository = detalleOrdenRepository;
        this.detalleOrdenMapper = detalleOrdenMapper;
    }

    /**
     * Saves a new DetalleOrden entity.
     *
     * @param dto DetalleOrdenRequestDto containing data to save
     * @return DetalleOrdenResponseDto with saved entity data
     */
    @Override
    @Transactional
    public DetalleOrdenResponseDto save(DetalleOrdenRequestDto dto) {
        // Basic validation
        if (dto == null) {
            throw new IllegalArgumentException("DetalleOrdenRequestDto cannot be null");
        }
        var entity = detalleOrdenMapper.toEntity(dto);
        var saved = detalleOrdenRepository.save(entity);
        return detalleOrdenMapper.toResponseDto(saved);
    }

    /**
     * Updates an existing DetalleOrden entity by id.
     *
     * @param id primary key of the DetalleOrden to update
     * @param dto DetalleOrdenRequestDto containing updated data
     * @return DetalleOrdenResponseDto with updated entity data
     * @throws DetalleOrdenNotFoundException if entity with id not found
     */
    @Override
    @Transactional
    public DetalleOrdenResponseDto update(Long id, DetalleOrdenRequestDto dto) throws DetalleOrdenNotFoundException {
        if (dto == null) {
            throw new IllegalArgumentException("DetalleOrdenRequestDto cannot be null");
        }
        // Verify existence
        detalleOrdenRepository.findById(id).orElseThrow(() -> new DetalleOrdenNotFoundException("DetalleOrden not found with id: " + id));

        var entity = detalleOrdenMapper.toEntity(dto);
        entity.setDetalleId(id);
        var updated = detalleOrdenRepository.save(entity);
        return detalleOrdenMapper.toResponseDto(updated);
    }

    /**
     * Finds a DetalleOrdenProjection by id.
     *
     * @param id primary key of the DetalleOrden
     * @return DetalleOrdenProjection projection
     * @throws DetalleOrdenNotFoundException if entity with id not found
     */
    @Override
    public DetalleOrdenProjection findById(Long id) throws DetalleOrdenNotFoundException {
        return detalleOrdenRepository.findProjectionById(id)
                .orElseThrow(() -> new DetalleOrdenNotFoundException("DetalleOrden not found with id: " + id));
    }

    /**
     * Finds all DetalleOrdenProjection entities.
     *
     * @return list of DetalleOrdenProjection
     */
    @Override
    public List<DetalleOrdenProjection> findAll() {
        return detalleOrdenRepository.findAllProjections();
    }

    /**
     * Deletes a DetalleOrden entity by id.
     *
     * @param id primary key of the DetalleOrden to delete
     * @throws DetalleOrdenNotFoundException if entity with id not found
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws DetalleOrdenNotFoundException {
        var entity = detalleOrdenRepository.findById(id)
                .orElseThrow(() -> new DetalleOrdenNotFoundException("DetalleOrden not found with id: " + id));
        detalleOrdenRepository.delete(entity);
    }
}