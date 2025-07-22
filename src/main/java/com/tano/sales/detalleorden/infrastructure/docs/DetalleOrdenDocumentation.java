package com.tano.sales.detalleorden.infrastructure.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
import com.tano.sales.detalleorden.dto.DetalleOrdenRequestDto;
import com.tano.sales.detalleorden.dto.DetalleOrdenResponseDto;

/**
 * Documentation class for DetalleOrden REST API.
 * Contains OpenAPI annotations for controller methods and DTOs.
 */
public class DetalleOrdenDocumentation {

    /**
     * Documentation for DetalleOrdenControllerDefinition interface methods.
     */
    public interface ControllerDefinitionDocs {

        @Operation(summary = "Create a new DetalleOrden")
        DetalleOrdenResponseDto createDetalleOrden(@Schema(description = "DetalleOrden request data") DetalleOrdenRequestDto detalleOrdenRequestDto);

        @Operation(summary = "Get a DetalleOrden by its ID")
        DetalleOrdenResponseDto getDetalleOrdenById(@Schema(description = "ID of the DetalleOrden to retrieve") Long detalleId);

        @Operation(summary = "Update an existing DetalleOrden")
        DetalleOrdenResponseDto updateDetalleOrden(@Schema(description = "ID of the DetalleOrden to update") Long detalleId,
                                                   @Schema(description = "Updated DetalleOrden data") DetalleOrdenRequestDto detalleOrdenRequestDto);

        @Operation(summary = "Delete a DetalleOrden by its ID")
        void deleteDetalleOrden(@Schema(description = "ID of the DetalleOrden to delete") Long detalleId);
    }

    /**
     * Documentation for DetalleOrdenRequestDto fields.
     */
    public static class DetalleOrdenRequestDtoDocs extends DetalleOrdenRequestDto {

        @Schema(description = "ID of the order this detail belongs to", required = true, example = "123")
        private Long ordenId;

        @Schema(description = "ID of the product", required = true, example = "456")
        private Long productoId;

        @Schema(description = "Quantity of the product ordered", required = true, example = "10", minimum = "1")
        private Integer cantidad;

        @Schema(description = "Unit price of the product", required = true, example = "99.99", minimum = "0")
        private Double precioUnitario;

        @Schema(description = "User who created the record", required = true, example = "admin")
        private String usuarioCreacion;
    }

    /**
     * Documentation for DetalleOrdenResponseDto fields.
     */
    public static class DetalleOrdenResponseDtoDocs extends DetalleOrdenResponseDto {

        @Schema(description = "Unique identifier of the DetalleOrden", example = "1")
        private Long detalleId;

        @Schema(description = "ID of the order this detail belongs to", example = "123")
        private Long ordenId;

        @Schema(description = "ID of the product", example = "456")
        private Long productoId;

        @Schema(description = "Quantity of the product ordered", example = "10")
        private Integer cantidad;

        @Schema(description = "Unit price of the product", example = "99.99")
        private Double precioUnitario;

        @Schema(description = "Subtotal calculated as cantidad * precioUnitario", example = "999.90")
        private Double subtotal;

        @Schema(description = "User who created the record", example = "admin")
        private String usuarioCreacion;
    }
}