package com.iftm.mentorship_client.exception;

/**
 * Exception thrown when a dependent service is unavailable.
 * HTTP Status: 503 Service Unavailable
 */
public class ServiceUnavailableException extends RuntimeException {
    
    public ServiceUnavailableException(String message) {
        super(message);
    }
    
    public ServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
