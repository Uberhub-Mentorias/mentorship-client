package com.iftm.mentorship_client.exception;

/**
 * Exception thrown when request validation fails or input is invalid.
 * HTTP Status: 400 Bad Request
 */
public class BadRequestException extends RuntimeException {
    
    public BadRequestException(String message) {
        super(message);
    }
    
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
