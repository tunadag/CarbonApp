package com.tunadag.exceptions.custom;

/**
 * @author Taha Yasin CINAR
 */
public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String message) {
        super(message);
    }
}
