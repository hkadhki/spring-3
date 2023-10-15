package com.example.spring2.controller;

import com.example.spring2.model.Authorities;
import com.example.spring2.service.AuthorizationService;
import com.example.spring2.exceptions.InvalidCredentials;
import com.example.spring2.exceptions.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    protected AuthorizationController(AuthorizationService service){
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser e){
        System.out.println(e.toString());
        return new ResponseEntity<>(e.toString(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials e){
        return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
    }
}
