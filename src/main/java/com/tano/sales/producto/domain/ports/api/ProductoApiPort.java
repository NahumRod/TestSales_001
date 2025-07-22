package com.tano.sales.producto.domain.ports.api;

import com.tano.sales.producto.dto.ProductoRequestDto;
import com.tano.sales.producto.dto.ProductoResponseDto;
import com.tano.sales.producto.projection.ProductoProjection;
import java.util.List;

/**
 * API Port interface for Producto.
 * <p>
 * Defines the operations available for Producto at the API layer.
 * Implemented by the service layer and used by controllers.
 */
public interface ProductoApiPort {

    /**
     * Saves a new Producto using the provided DTO.
     *
     * @param dto the DTO containing the data for the new Producto
     * @return the saved Producto as a DTO
     */
    ProductoResponseDto save(ProductoRequestDto dto);

    /**
     * Updates an existing Producto with the provided DTO.
     *
     * @param id  the ID of the Producto to update
     * @param dto the DTO containing the updated data for the Producto
     * @return the updated Producto as a DTO
     */
    ProductoResponseDto update(Long id, ProductoRequestDto dto);

    /**
     * Finds a Producto by its ID.
     *
     * @param id the ID of the Producto to find
     * @return the found Producto as a Projection
     */
    ProductoProjection findById(Long id);

    /**
     * Finds all Productos.
     *
     * @return a list of all Productos as Projections
     */
    List<ProductoProjection> findAll();

    /**
     * Deletes a Producto by its ID.
     *
     * @param id the ID of the Producto to delete
     */
    void deleteById(Long id);
}