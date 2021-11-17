package com.challenge.service.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg) { // sobrecarga
        super(msg);
    }
}
