package com.example.spring2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

//    @ExceptionHandler(UnauthorizedUser.class)
//    public ResponseEntity<String> uuHandler(UnauthorizedUser e){
//        System.out.println(e.toString());
//        return new ResponseEntity<>(e.toString(), HttpStatus.UNAUTHORIZED);
//    }
//
//    @ExceptionHandler(InvalidCredentials.class)
//    public ResponseEntity<String> icHandler(InvalidCredentials e){
//        return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
//    }
}
