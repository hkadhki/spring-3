package com.example.spring2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service){
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
