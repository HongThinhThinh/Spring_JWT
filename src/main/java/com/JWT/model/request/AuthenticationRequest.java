package com.JWT.model.request;

import com.JWT.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    String firstName;
    String lastName;
    String username;
    String password;
    Role role;
}
