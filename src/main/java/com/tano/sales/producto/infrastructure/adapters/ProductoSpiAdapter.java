package com.tano.sales.producto.infrastructure.adapters;

import com.tano.sales.producto.domain.ports.spi.ProductoSpiPort;
import com.tano.sales.producto.dto.ProductoRequestDto;
import com.tano.sales.producto.dto.ProductoResponseDto;
import com.tano.sales.producto.infrastructure.entity.Producto;
import com.tano.sales.producto.infrastructure.mappers.ProductoMapper;
import com.tano.sales.producto.infrastructure.projection.ProductoProjection;
import com.tano.sales.producto.infrastructure.repository.ProductoRepository;
import com.tano.sales.producto.infrastructure.exceptions.ProductoNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * SPI Adapter implementation for Producto entity.
 * Handles persistence operations using ProductoRepository and maps entities to DTOs and projections.
 */
public class ProductoSpiAdapter implements ProductoSpiPort {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    /**
     * Constructor injection of repository and mapper.
     *
     * @param productoRepository the Producto repository
     * @param productoMapper the Producto mapper
     */
    public ProductoSpiAdapter(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    /**
     * Saves a new Producto entity.
     *
     * @param dto the ProductoRequestDto containing data to save
     * @return the ProductoResponseDto of the saved entity
     */
    @Override
    @Transactional
    public ProductoResponseDto save(ProductoRequestDto dto) {
        Producto entity = productoMapper.toEntity(dto);
        Producto saved = productoRepository.save(entity);
        return productoMapper.toResponseDto(saved);
    }

    /**
     * Updates an existing Producto entity by id.
     *
     * @param id the id of the Producto to update
     * @param dto the ProductoRequestDto containing updated data
     * @return the ProductoResponseDto of the updated entity
     * @throws ProductoNotFoundException if the Producto with the given id does not exist
     */
    @Override
    @Transactional
    public ProductoResponseDto update(Long id, ProductoRequestDto dto) throws ProductoNotFoundException {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNotFoundException("Producto not found with id: " + id);
        }
        Producto entity = productoMapper.toEntity(dto);
        entity.setProductoId(id);
        Producto updated = productoRepository.save(entity);
        return productoMapper.toResponseDto(updated);
    }

    /**
     * Finds a ProductoProjection by id.
     *
     * @param id the id of the Producto to find
     * @return the ProductoProjection
     * @throws ProductoNotFoundException if the Producto with the given id does not exist
     */
    @Override
    public ProductoProjection findById(Long id) throws ProductoNotFoundException {
        Optional<ProductoProjection> optionalProjection = productoRepository.findProjectionById(id);
        return optionalProjection.orElseThrow(() -> new ProductoNotFoundException("Producto not found with id: " + id));
    }

    /**
     * Finds all ProductoProjection entities.
     *
     * @return list of ProductoProjection
     */
    @Override
    public List<ProductoProjection> findAll() {
        return productoRepository.findAllProjections();
    }

    /**
     * Deletes a Producto entity by id.
     *
     * @param id the id of the Producto to delete
     * @throws ProductoNotFoundException if the Producto with the given id does not exist
     */
    @Override
    @Transactional
    public void deleteById(Long id) throws ProductoNotFoundException {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNotFoundException("Producto not found with id: " + id);
        }
        productoRepository.deleteById(id);
    }
}