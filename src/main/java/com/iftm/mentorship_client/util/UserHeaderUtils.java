package com.iftm.mentorship_client.util;

import com.iftm.mentorship_client.model.enums.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Utility class to extract user information from request headers.
 * These headers are propagated by the API Gateway after JWT validation.
 * 
 * Usage in controllers:
 * <pre>
 * String userId = UserHeaderUtils.getUserId();
 * String email = UserHeaderUtils.getUserEmail();
 * List&lt;Role&gt; roles = UserHeaderUtils.getUserRoles();
 * boolean isAdmin = UserHeaderUtils.hasRole(Role.ADMIN);
 * </pre>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserHeaderUtils {
    
    private static final String X_USER_ID_HEADER = "X-User-Id";
    private static final String X_EMAIL_HEADER = "X-Email";
    private static final String X_ROLES_HEADER = "X-Roles";
    
    /**
     * Gets the current authenticated user ID from request headers.
     * 
     * @param request the HTTP servlet request
     * @return the user ID
     * @throws IllegalStateException if user ID header is not present
     */
    public static String getUserId(HttpServletRequest request) {
        String userId = request.getHeader(X_USER_ID_HEADER);
        if (userId == null || userId.isBlank()) {
            throw new IllegalStateException("User ID not found in request headers");
        }
        return userId;
    }
    
    /**
     * Gets the current authenticated user ID as Optional.
     * 
     * @param request the HTTP servlet request
     * @return Optional containing user ID if present
     */
    public static Optional<String> getUserIdOptional(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(X_USER_ID_HEADER))
                .filter(s -> !s.isBlank());
    }
    
    /**
     * Gets the current authenticated user email from request headers.
     * 
     * @param request the HTTP servlet request
     * @return the user email
     * @throws IllegalStateException if email header is not present
     */
    public static String getUserEmail(HttpServletRequest request) {
        String email = request.getHeader(X_EMAIL_HEADER);
        if (email == null || email.isBlank()) {
            throw new IllegalStateException("User email not found in request headers");
        }
        return email;
    }
    
    /**
     * Gets the current authenticated user email as Optional.
     * 
     * @param request the HTTP servlet request
     * @return Optional containing email if present
     */
    public static Optional<String> getUserEmailOptional(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(X_EMAIL_HEADER))
                .filter(s -> !s.isBlank());
    }
    
    /**
     * Gets the current authenticated user roles from request headers.
     * Parses the comma-separated roles string into a List of Role enums.
     * 
     * @param request the HTTP servlet request
     * @return list of user roles, empty list if header not present or parsing fails
     */
    public static List<Role> getUserRoles(HttpServletRequest request) {
        String rolesStr = request.getHeader(X_ROLES_HEADER);
        if (rolesStr == null || rolesStr.isBlank()) {
            return Collections.emptyList();
        }
        
        return Arrays.stream(rolesStr.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(roleStr -> {
                    try {
                        return Role.valueOf(roleStr);
                    } catch (IllegalArgumentException e) {
                        return null;
                    }
                })
                .filter(role -> role != null)
                .collect(Collectors.toList());
    }
    
    /**
     * Checks if the current user has a specific role.
     * 
     * @param request the HTTP servlet request
     * @param role the role to check
     * @return true if user has the role, false otherwise
     */
    public static boolean hasRole(HttpServletRequest request, Role role) {
        return getUserRoles(request).contains(role);
    }
    
    /**
     * Checks if the current user has any of the specified roles.
     * 
     * @param request the HTTP servlet request
     * @param roles the roles to check
     * @return true if user has at least one of the roles
     */
    public static boolean hasAnyRole(HttpServletRequest request, Role... roles) {
        List<Role> userRoles = getUserRoles(request);
        return Arrays.stream(roles).anyMatch(userRoles::contains);
    }
    
    /**
     * Checks if the current user has all of the specified roles.
     * 
     * @param request the HTTP servlet request
     * @param roles the roles to check
     * @return true if user has all the roles
     */
    public static boolean hasAllRoles(HttpServletRequest request, Role... roles) {
        List<Role> userRoles = getUserRoles(request);
        return Arrays.stream(roles).allMatch(userRoles::contains);
    }
    
    /**
     * Checks if the current user is an admin.
     * 
     * @param request the HTTP servlet request
     * @return true if user has ADMIN role
     */
    public static boolean isAdmin(HttpServletRequest request) {
        return hasRole(request, Role.ADMIN);
    }
    
    /**
     * Validates that the current user is the owner of a resource.
     * 
     * @param request the HTTP servlet request
     * @param resourceOwnerId the ID of the resource owner
     * @throws IllegalStateException if current user is not the owner
     */
    public static void requireOwnership(HttpServletRequest request, String resourceOwnerId) {
        String currentUserId = getUserId(request);
        if (!currentUserId.equals(resourceOwnerId)) {
            throw new IllegalStateException("User is not authorized to access this resource");
        }
    }
    
    /**
     * Checks if the current user is the owner of a resource.
     * 
     * @param request the HTTP servlet request
     * @param resourceOwnerId the ID of the resource owner
     * @return true if current user is the owner
     */
    public static boolean isOwner(HttpServletRequest request, String resourceOwnerId) {
        return getUserIdOptional(request)
                .map(userId -> userId.equals(resourceOwnerId))
                .orElse(false);
    }
}
