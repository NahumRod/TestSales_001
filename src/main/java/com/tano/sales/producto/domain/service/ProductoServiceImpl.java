package com.tano.sales.producto.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.tano.sales.producto.domain.ports.api.ProductoApiPort;
import com.tano.sales.producto.domain.ports.spi.ProductoSpiPort;
import com.tano.sales.producto.dto.ProductoRequestDto;
import com.tano.sales.producto.projection.ProductoProjection;

/**
 * Service implementation for Producto entity.
 * Acts as a bridge between the controller and the persistence SPI port.
 * Delegates all operations to the ProductoSpiPort.
 */
@Service
public class ProductoServiceImpl implements ProductoApiPort {

    private final ProductoSpiPort productoSpiPort;

    /**
     * Constructor injection of the SPI port.
     *
     * @param productoSpiPort the SPI port for Producto persistence operations
     */
    public ProductoServiceImpl(ProductoSpiPort productoSpiPort) {
        this.productoSpiPort = productoSpiPort;
    }

    /**
     * Saves a new Producto.
     *
     * @param dto the ProductoRequestDto containing data to save
     * @return the saved ProductoResponseDto
     */
    @Override
    public com.tano.sales.producto.dto.ProductoResponseDto save(ProductoRequestDto dto) {
        return productoSpiPort.save(dto);
    }

    /**
     * Updates an existing Producto by id.
     *
     * @param id the Producto id
     * @param dto the ProductoRequestDto containing updated data
     * @return the updated ProductoResponseDto
     */
    @Override
    public com.tano.sales.producto.dto.ProductoResponseDto update(Long id, ProductoRequestDto dto) {
        return productoSpiPort.update(id, dto);
    }

    /**
     * Finds a Producto by id.
     *
     * @param id the Producto id
     * @return the ProductoProjection
     */
    @Override
    public ProductoProjection findById(Long id) {
        return productoSpiPort.findById(id);
    }

    /**
     * Finds all Productos.
     *
     * @return list of ProductoProjection
     */
    @Override
    public List<ProductoProjection> findAll() {
        return productoSpiPort.findAll();
    }

    /**
     * Deletes a Producto by id.
     *
     * @param id the Producto id
     */
    @Override
    public void deleteById(Long id) {
        productoSpiPort.deleteById(id);
    }
}