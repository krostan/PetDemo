package com.pet.cool.Exception;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException() {
        super();
    }

    public PetNotFoundException(String message) {
        super(message);
    }

    public PetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

