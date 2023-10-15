package com.example.spring2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    Map<String,User> usres = new HashMap<>();

    public UserRepository(){
        usres.put("Ivan", new User("Ivan","qwerty"));
        usres.get("Ivan").addAuthotities(Authorities.WRITE);
        usres.put("Petya",new User("Petya","Kjabjh123kbb2"));
        usres.put("Ilya",new User("Ilya", "Qwe123"));
        usres.get("Ilya").addAuthotities(Authorities.DELETE);

    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        try {
            if (password.equals(usres.get(user).getPassword())){
                return usres.get(user).getAuthorities();
            }
        }catch (NullPointerException e){
            return new ArrayList<Authorities>() ;
        }
        return new ArrayList<Authorities>() ;
    }
}
