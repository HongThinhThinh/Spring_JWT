package com.JWT.service;


import com.JWT.model.AuthenticationResponse;
import com.JWT.model.User;
import com.JWT.repository.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JWTService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;

    public AuthenticationResponse register(User request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user = userRepository.save(user);
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.
                builder()
                .role(request.getRole())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .Username(request.getUsername())
                .token(token).build();
    }
    public AuthenticationResponse authenticate(User request){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        }catch (Exception e) {
            throw new NullPointerException("Wrong Id Or Password") ;
        }
        User user =userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.
                builder()
                .role(request.getRole())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .Username(request.getUsername())
                .token(token).build();
    }

}

