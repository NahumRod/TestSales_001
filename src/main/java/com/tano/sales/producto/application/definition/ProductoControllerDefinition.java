package com.tano.sales.producto.application.definition;

import com.tano.sales.producto.dto.ProductoRequestDto;
import com.tano.sales.producto.dto.ProductoResponseDto;
import com.tano.sales.producto.projection.ProductoProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Defines the REST API endpoints for Producto entity.
 * This interface is implemented by the ProductoControllerImplementation
 * and must align exactly with it.
 */
public interface ProductoControllerDefinition {

    /**
     * Creates a new Producto.
     *
     * @param dto the ProductoRequestDto containing the data to create
     * @return ResponseEntity containing the created ProductoResponseDto
     */
    @PostMapping("/")
    ResponseEntity<ProductoResponseDto> save(@RequestBody ProductoRequestDto dto);

    /**
     * Updates an existing Producto identified by id.
     *
     * @param id the primary key of the Producto to update
     * @param dto the ProductoRequestDto containing the updated data
     * @return ResponseEntity containing the updated ProductoResponseDto
     */
    @PutMapping("/{id}")
    ResponseEntity<ProductoResponseDto> update(@PathVariable Long id, @RequestBody ProductoRequestDto dto);

    /**
     * Finds a Producto by its id.
     *
     * @param id the primary key of the Producto to find
     * @return ResponseEntity containing the ProductoProjection
     */
    @GetMapping("/{id}")
    ResponseEntity<ProductoProjection> findById(@PathVariable Long id);

    /**
     * Retrieves all Productos.
     *
     * @return ResponseEntity containing a list of ProductoProjection
     */
    @GetMapping("/")
    ResponseEntity<java.util.List<ProductoProjection>> findAll();

    /**
     * Deletes a Producto by its id.
     *
     * @param id the primary key of the Producto to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}
