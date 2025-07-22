package com.tano.sales.orden.infrastructure.advice;

import com.tano.sales.orden.infrastructure.exceptions.OrdenNotFoundException;
import com.tano.sales.orden.infrastructure.exceptions.OrdenValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global controller advice for handling exceptions related to Orden entity.
 * Provides centralized exception handling and meaningful JSON error responses.
 */
@RestControllerAdvice
public class OrdenControllerAdvice {

    /**
     * Handles OrdenNotFoundException and returns a 404 Not Found response.
     *
     * @param ex the OrdenNotFoundException thrown
     * @return ResponseEntity with error details and HTTP status 404
     */
    @ExceptionHandler(OrdenNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(OrdenNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles OrdenValidationException and returns a 400 Bad Request response.
     *
     * @param ex the OrdenValidationException thrown
     * @return ResponseEntity with error details and HTTP status 400
     */
    @ExceptionHandler(OrdenValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(OrdenValidationException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * DTO for error response payload.
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