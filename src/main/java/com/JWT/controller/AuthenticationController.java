package com.JWT.controller;


import com.JWT.model.AuthenticationResponse;
import com.JWT.model.User;
import com.JWT.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User user){
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthenticationResponse> login(@RequestBody User user){
        return ResponseEntity.ok(authenticationService.authenticate(user));
    }

    @GetMapping("/testRole")
    public ResponseEntity testRole(){
        return ResponseEntity.ok("Test Role User Successfully");
    }
    @GetMapping("/admin-only")
    public ResponseEntity admin(){
        return ResponseEntity.ok("Admin Only");
    }



}
