package com.example.spring2;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}