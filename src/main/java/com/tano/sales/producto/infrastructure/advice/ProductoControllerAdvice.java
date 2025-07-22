package com.tano.sales.producto.infrastructure.advice;

import com.tano.sales.producto.infrastructure.exceptions.ProductoNotFoundException;
import com.tano.sales.producto.infrastructure.exceptions.ProductoValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Global controller advice for handling exceptions related to Producto entity.
 * Provides meaningful JSON error responses with appropriate HTTP status codes.
 */
@RestControllerAdvice
public class ProductoControllerAdvice {

    /**
     * Handles ProductoNotFoundException exceptions.
     * Returns a 404 Not Found status with error details.
     *
     * @param ex the ProductoNotFoundException thrown
     * @return ResponseEntity with error response and 404 status
     */
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ProductoNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Producto Not Found",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles ProductoValidationException exceptions.
     * Returns a 400 Bad Request status with error details.
     *
     * @param ex the ProductoValidationException thrown
     * @return ResponseEntity with error response and 400 status
     */
    @ExceptionHandler(ProductoValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(ProductoValidationException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * DTO for error response payload.
     */
    public static class ErrorResponse {
        private int status;
        private String error;
        private String message;
        private LocalDateTime timestamp;

        public ErrorResponse(int status, String error, String message, LocalDateTime timestamp) {
            this.status = status;
            this.error = error;
            this.message = message;
            this.timestamp = timestamp;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }
    }
}