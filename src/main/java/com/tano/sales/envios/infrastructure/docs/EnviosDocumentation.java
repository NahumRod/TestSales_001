package com.tano.sales.envios.infrastructure.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Documentation annotations for Envios REST API and DTOs.
 * <p>
 * This class centralizes OpenAPI documentation annotations for the Envios module,
 * including summaries for controller methods and schema descriptions for DTO fields.
 */
public class EnviosDocumentation {

    /**
     * Documentation for EnviosControllerDefinition methods.
     */
    public interface ControllerDefinition {

        @Operation(summary = "Create a new envio record")
        void createEnvio();

        @Operation(summary = "Retrieve an envio by its ID")
        void getEnvioById();

        @Operation(summary = "Update an existing envio record")
        void updateEnvio();

        @Operation(summary = "Delete an envio by its ID")
        void deleteEnvio();

        @Operation(summary = "List all envios")
        void listEnvios();
    }

    /**
     * Schema descriptions for EnviosRequestDto fields.
     */
    public interface RequestDto {

        @Schema(description = "Identifier of the order associated with the envio")
        void ordenId();

        @Schema(description = "Date when the envio was sent")
        void fechaEnvio();

        @Schema(description = "Shipping address")
        void direccionEnvio();

        @Schema(description = "City of the shipping address")
        void ciudad();

        @Schema(description = "Country of the shipping address, defaults to Argentina")
        void pais();

        @Schema(description = "Postal code of the shipping address")
        void codigoPostal();

        @Schema(description = "Shipping company handling the envio")
        void empresaEnvio();

        @Schema(description = "Current status of the envio, e.g., Pendiente, En Camino, Entregado, Devuelto")
        void estadoEnvio();

        @Schema(description = "User who created the envio record")
        void usuarioCreacion();
    }

    /**
     * Schema descriptions for EnviosResponseDto fields.
     */
    public interface ResponseDto {

        @Schema(description = "Unique identifier of the envio")
        void envioId();

        @Schema(description = "Identifier of the order associated with the envio")
        void ordenId();

        @Schema(description = "Date when the envio was sent")
        void fechaEnvio();

        @Schema(description = "Shipping address")
        void direccionEnvio();

        @Schema(description = "City of the shipping address")
        void ciudad();

        @Schema(description = "Country of the shipping address")
        void pais();

        @Schema(description = "Postal code of the shipping address")
        void codigoPostal();

        @Schema(description = "Shipping company handling the envio")
        void empresaEnvio();

        @Schema(description = "Current status of the envio")
        void estadoEnvio();

        @Schema(description = "User who created the envio record")
        void usuarioCreacion();
    }
}