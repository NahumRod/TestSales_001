package com.tano.sales.envios.infrastructure.advice;

import com.tano.sales.envios.infrastructure.exceptions.EnviosNotFoundException;
import com.tano.sales.envios.infrastructure.exceptions.EnviosValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global controller advice for handling exceptions related to Envios.
 * Provides meaningful JSON error responses with appropriate HTTP status codes.
 */
@RestControllerAdvice
public class EnviosControllerAdvice {

    /**
     * Handles EnviosNotFoundException and returns a 404 Not Found response.
     *
     * @param ex the EnviosNotFoundException
     * @return ResponseEntity with error details and 404 status
     */
    @ExceptionHandler(EnviosNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(EnviosNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Envios Not Found",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles EnviosValidationException and returns a 400 Bad Request response.
     *
     * @param ex the EnviosValidationException
     * @return ResponseEntity with error details and 400 status
     */
    @ExceptionHandler(EnviosValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(EnviosValidationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles MethodArgumentNotValidException thrown when @Valid validation fails.
     * Returns a 400 Bad Request response with detailed field errors.
     *
     * @param ex the MethodArgumentNotValidException
     * @return ResponseEntity with error details and 400 status
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                fieldErrors.toString(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
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