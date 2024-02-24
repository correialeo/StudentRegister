package br.com.scolarship.system.Service;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
