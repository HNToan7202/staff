package com.example.staff.exception;

public class InvalidPhone extends Exception {
    public InvalidPhone(String message) {
        super(message);
    }
    public InvalidPhone(String message, Throwable cause) {
        super(message, cause);
    }
}
