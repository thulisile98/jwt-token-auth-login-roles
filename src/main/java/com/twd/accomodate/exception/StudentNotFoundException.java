package com.twd.accomodate.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String s) {
        super("student not found");
    }
}
