package com.example.JFS.Mini.Project_1.exceptions;

public class EmailAlreadyExistException extends RuntimeException {

    public EmailAlreadyExistException(String s) {
        System.out.println(s);
    }
}
