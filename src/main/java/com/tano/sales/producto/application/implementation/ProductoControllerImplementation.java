package com.tano.sales.producto.application.implementation;

import com.tano.sales.producto.application.definition.ProductoControllerDefinition;
import com.tano.sales.producto.domain.ports.api.ProductoApiPort;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller implementation for Producto entity.
 * Delegates calls to ProductoApiPort service.
 */
@RestController
@RequestMapping("/productos")
public class ProductoControllerImplementation implements ProductoControllerDefinition {

    private final ProductoApiPort productoApiPort;

    /**
     * Constructor injection of ProductoApiPort.
     *
     * @param productoApiPort the API port for Producto
     */
    public ProductoControllerImplementation(ProductoApiPort productoApiPort) {
        this.productoApiPort = productoApiPort;
    }

    /**
     * Save a new Producto.
     *
     * @param dto the ProductoRequestDto
     * @return the saved ProductoResponseDto wrapped in ResponseEntity
     */
    @Override
    @PostMapping
    public ResponseEntity<ProductoResponseDto> save(@RequestBody ProductoRequestDto dto) {
        return ResponseEntity.ok(productoApiPort.save(dto));
    }

    /**
     * Update an existing Producto by id.
     *
     * @param id  the Producto id
     * @param dto the ProductoRequestDto with updated data
     * @return the updated ProductoResponseDto wrapped in ResponseEntity
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> update(@PathVariable Long id, @RequestBody ProductoRequestDto dto) {
        return ResponseEntity.ok(productoApiPort.update(id, dto));
    }

    /**
     * Find a Producto by id.
     *
     * @param id the Producto id
     * @return the ProductoProjection wrapped in ResponseEntity
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductoProjection> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productoApiPort.findById(id));
    }

    /**
     * Find all Productos.
     *
     * @return list of ProductoProjection wrapped in ResponseEntity
     */
    @Override
    @GetMapping
    public ResponseEntity<List<ProductoProjection>> findAll() {
        return ResponseEntity.ok(productoApiPort.findAll());
    }

    /**
     * Delete a Producto by id.
     *
     * @param id the Producto id
     * @return ResponseEntity with no content
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productoApiPort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
