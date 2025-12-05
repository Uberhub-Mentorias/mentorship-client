package com.iftm.mentorship_client.exception;

/**
 * Exception thrown when authentication fails or token is invalid.
 * HTTP Status: 401 Unauthorized
 */
public class UnauthorizedException extends RuntimeException {
    
    public UnauthorizedException(String message) {
        super(message);
    }
    
    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
