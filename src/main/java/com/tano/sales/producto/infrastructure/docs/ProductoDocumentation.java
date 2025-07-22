package com.tano.sales.producto.infrastructure.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
import com.tano.sales.producto.dto.ProductoRequestDto;
import com.tano.sales.producto.dto.ProductoResponseDto;
import com.tano.sales.producto.application.definition.ProductoControllerDefinition;

/**
 * Documentation annotations for Producto REST API.
 * <p>
 * This class provides OpenAPI documentation for Producto controller methods and DTOs.
 */
public class ProductoDocumentation {

    /**
     * Documentation for ProductoControllerDefinition interface.
     */
    public interface ProductoControllerDefinitionDoc extends ProductoControllerDefinition {

        @Override
        @Operation(summary = "Create a new Producto")
        ProductoResponseDto createProducto(@Schema(description = "Producto data to create") ProductoRequestDto productoRequestDto);

        @Override
        @Operation(summary = "Get a Producto by its ID")
        ProductoResponseDto getProductoById(@Schema(description = "ID of the Producto to retrieve") Long productoId);

        @Override
        @Operation(summary = "Update an existing Producto")
        ProductoResponseDto updateProducto(@Schema(description = "ID of the Producto to update") Long productoId,
                                          @Schema(description = "Updated Producto data") ProductoRequestDto productoRequestDto);

        @Override
        @Operation(summary = "Delete a Producto by its ID")
        void deleteProducto(@Schema(description = "ID of the Producto to delete") Long productoId);

        @Override
        @Operation(summary = "List all Productos")
        java.util.List<ProductoResponseDto> listProductos();
    }

    /**
     * Documentation for ProductoRequestDto.
     */
    public static class ProductoRequestDtoDoc extends ProductoRequestDto {

        @Schema(description = "Name of the Producto", example = "Laptop XYZ")
        private String nombre;

        @Schema(description = "Detailed description of the Producto", example = "High performance laptop with 16GB RAM")
        private String descripcion;

        @Schema(description = "Unit price of the Producto", example = "999.99", minimum = "0.01")
        private java.math.BigDecimal precioUnitario;

        @Schema(description = "Category of the Producto", example = "Electronics")
        private String categoria;

        @Schema(description = "Stock quantity available", example = "100", minimum = "0")
        private Integer stock;

        @Schema(description = "Estado of the Producto: 'A' for Active, 'I' for Inactive", example = "A")
        private String estado;

        @Schema(description = "User who created the Producto", example = "admin")
        private String usuarioCreacion;
    }

    /**
     * Documentation for ProductoResponseDto.
     */
    public static class ProductoResponseDtoDoc extends ProductoResponseDto {

        @Schema(description = "Unique identifier of the Producto", example = "1")
        private Long productoId;

        @Schema(description = "Name of the Producto", example = "Laptop XYZ")
        private String nombre;

        @Schema(description = "Detailed description of the Producto", example = "High performance laptop with 16GB RAM")
        private String descripcion;

        @Schema(description = "Unit price of the Producto", example = "999.99")
        private java.math.BigDecimal precioUnitario;

        @Schema(description = "Category of the Producto", example = "Electronics")
        private String categoria;

        @Schema(description = "Stock quantity available", example = "100")
        private Integer stock;

        @Schema(description = "Estado of the Producto: 'A' for Active, 'I' for Inactive", example = "A")
        private String estado;

        @Schema(description = "Date when the Producto was created", example = "2024-01-01T00:00:00Z")
        private java.util.Date fechaAlta;

        @Schema(description = "User who created the Producto", example = "admin")
        private String usuarioCreacion;
    }
}