package com.iftm.mentorship_client.exception;

/**
 * Exception thrown when a requested resource is not found.
 * HTTP Status: 404 Not Found
 */
public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message) {
        super(message);
    }
    
    public NotFoundException(String resource, String id) {
        super(String.format("%s not found with id: %s", resource, id));
    }
    
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
