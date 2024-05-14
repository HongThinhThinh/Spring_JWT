package com.JWT.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    String token;
    String Username;
    Role role;
    String firstname;
    String lastname;

}

