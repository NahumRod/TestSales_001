package com.tano.sales.detalleorden.infrastructure.advice;

import com.tano.sales.detalleorden.infrastructure.exceptions.DetalleOrdenNotFoundException;
import com.tano.sales.detalleorden.infrastructure.exceptions.DetalleOrdenValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global controller advice for handling exceptions related to DetalleOrden.
 * Provides meaningful HTTP responses for known exceptions.
 */
@RestControllerAdvice
public class DetalleOrdenControllerAdvice {

    /**
     * Handles DetalleOrdenNotFoundException and returns a 404 Not Found response.
     *
     * @param ex the DetalleOrdenNotFoundException thrown
     * @return ResponseEntity with error details and HTTP status 404
     */
    @ExceptionHandler(DetalleOrdenNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(DetalleOrdenNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles DetalleOrdenValidationException and returns a 400 Bad Request response.
     *
     * @param ex the DetalleOrdenValidationException thrown
     * @return ResponseEntity with error details and HTTP status 400
     */
    @ExceptionHandler(DetalleOrdenValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(DetalleOrdenValidationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Simple DTO for error response payload.
     */
    public static class ErrorResponse {
        private int status;
        private String message;

        public ErrorResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}