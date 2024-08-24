package dev.feileen.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter and setters 
@AllArgsConstructor
@NoArgsConstructor

public class UserRegistrationRequest {
    private String username;
    private String password;
}
