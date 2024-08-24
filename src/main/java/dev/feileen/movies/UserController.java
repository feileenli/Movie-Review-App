package dev.feileen.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/v1/register")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your frontend


public class UserController {

    @Autowired 
    private UserService userService; 

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest req) {
       
            if(userService.findByUsername(req.getUsername()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username is already taken"); 
            }
            User user = new User();
            user.setUsername(req.getUsername()); 
            user.setPassword(passwordEncoder.encode(req.getPassword())); 

            userRepository.save(user); 
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully"); 
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }
    
}
