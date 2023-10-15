package com.example.spring2;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}