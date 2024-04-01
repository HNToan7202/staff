package com.example.staff.exception;

public class InvalidID extends Exception{
    public InvalidID(String message) {
        super(message);
    }
    public InvalidID(String message, Throwable cause) {
        super(message, cause);
    }
}
