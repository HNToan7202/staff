package com.example.staff.exception;

public class InvalidEmail extends Exception{
    public InvalidEmail(String message) {
        super(message);
    }
    public InvalidEmail(String message, Throwable cause) {
        super(message, cause);
    }
}
