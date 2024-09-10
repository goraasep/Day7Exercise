package org.example.Day7Exercise.exceptions;

public class NoElementException extends RuntimeException {
    public NoElementException() {
        super("Elements not found.");
    }
}
