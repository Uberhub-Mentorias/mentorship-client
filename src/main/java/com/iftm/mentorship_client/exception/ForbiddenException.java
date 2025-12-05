package com.iftm.mentorship_client.exception;

/**
 * Exception thrown when user does not have permission to access a resource.
 * HTTP Status: 403 Forbidden
 */
public class ForbiddenException extends RuntimeException {
    
    public ForbiddenException(String message) {
        super(message);
    }
    
    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}
