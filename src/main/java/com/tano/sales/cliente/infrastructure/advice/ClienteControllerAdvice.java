package com.tano.sales.cliente.infrastructure.advice;

import com.tano.sales.cliente.infrastructure.exceptions.ClienteNotFoundException;
import com.tano.sales.cliente.infrastructure.exceptions.ClienteValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global controller advice for handling exceptions related to Cliente entity.
 */
@RestControllerAdvice
public class ClienteControllerAdvice {

    /**
     * Handles ClienteNotFoundException and returns a 404 Not Found response.
     *
     * @param ex the exception thrown when a Cliente is not found
     * @return ResponseEntity with error details and HTTP status 404
     */
    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ClienteNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles ClienteValidationException and returns a 400 Bad Request response.
     *
     * @param ex the exception thrown when Cliente validation fails
     * @return ResponseEntity with error details and HTTP status 400
     */
    @ExceptionHandler(ClienteValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(ClienteValidationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
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