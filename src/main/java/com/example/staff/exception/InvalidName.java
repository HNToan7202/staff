package com.example.staff.exception;

public class InvalidName extends Exception{
    public InvalidName(String message) {
        super(message);
    }
    public InvalidName(String message, Throwable cause) {
        super(message, cause);
    }
}
