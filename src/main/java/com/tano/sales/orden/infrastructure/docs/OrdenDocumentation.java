package com.tano.sales.orden.infrastructure.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Documentation annotations for Orden related classes.
 * <p>
 * This class centralizes documentation annotations for REST controllers and DTOs
 * related to the Orden entity using springdoc-openapi.
 */
public class OrdenDocumentation {

    /**
     * Documentation for OrdenRequestDto fields.
     */
    public @interface OrdenRequestDtoDocs {

        @Schema(description = "Identifier of the client placing the order")
        long clienteId() default 0L;

        @Schema(description = "Date when the order was placed")
        java.util.Date fechaOrden() default @java.lang.SuppressWarnings("");

        @Schema(description = "Current status of the order")
        String estado() default "";

        @Schema(description = "Total amount of the order")
        double totalOrden() default 0.0;

        @Schema(description = "Payment method used for the order")
        String metodoPago() default "";

        @Schema(description = "Additional notes for the order")
        String notas() default "";

        @Schema(description = "User who created the order")
        String usuarioCreacion() default "";
    }

    /**
     * Documentation for OrdenResponseDto fields.
     */
    public @interface OrdenResponseDtoDocs {

        @Schema(description = "Unique identifier of the order")
        long ordenId() default 0L;

        @Schema(description = "Identifier of the client who placed the order")
        long clienteId() default 0L;

        @Schema(description = "Date when the order was placed")
        java.util.Date fechaOrden() default @java.lang.SuppressWarnings("");

        @Schema(description = "Current status of the order")
        String estado() default "";

        @Schema(description = "Total amount of the order")
        double totalOrden() default 0.0;

        @Schema(description = "Payment method used for the order")
        String metodoPago() default "";

        @Schema(description = "Additional notes for the order")
        String notas() default "";

        @Schema(description = "User who created the order")
        String usuarioCreacion() default "";
    }

    /**
     * Documentation for OrdenControllerImplementation REST endpoints.
     */
    public @interface OrdenControllerDocs {

        @Operation(summary = "Create a new order")
        void createOrden();

        @Operation(summary = "Retrieve an order by its ID")
        void getOrdenById();

        @Operation(summary = "Update an existing order")
        void updateOrden();

        @Operation(summary = "Delete an order by its ID")
        void deleteOrden();

        @Operation(summary = "List all orders")
        void listOrdenes();
    }
}