package com.iftm.mentorship_client.exception;

/**
 * Exception thrown when an unexpected server error occurs.
 * HTTP Status: 500 Internal Server Error
 */
public class InternalServerErrorException extends RuntimeException {
    
    public InternalServerErrorException(String message) {
        super(message);
    }
    
    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
