package dev.feileen.movies;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class UserService {
    @Autowired
    private UserRepository userRepository; 

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username); 
    }
    public List<User> allUsers() {
        return userRepository.findAll(); 
    }

    
}
