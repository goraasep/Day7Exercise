package org.example.Day7Exercise.exceptions;

public class LastElementException extends RuntimeException{
    public LastElementException(){
        super("Type 'q' to finish.");
    }
}
