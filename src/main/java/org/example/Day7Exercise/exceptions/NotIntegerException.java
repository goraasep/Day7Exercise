package org.example.Day7Exercise.exceptions;

public class NotIntegerException extends RuntimeException{
    public NotIntegerException() {
        super("Elements are not integer.");
    }
}
