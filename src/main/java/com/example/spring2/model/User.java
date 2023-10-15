package com.example.spring2.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    @Getter
    private String password;
    @Getter
    private List<Authorities> authorities = new ArrayList<>();


    public User(String name, String password){
        this.name = name;
        this.password = password;
        authorities.add(Authorities.READ);
    }

    public void addAuthotities(Authorities authorities){
        this.authorities.add(authorities);
    }

}
