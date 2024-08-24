package dev.feileen.movies;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data // getter and setters 
@Builder 
@AllArgsConstructor
@NoArgsConstructor

public class User implements UserDetails {
    @Id
    private String id; 
    private String username; 
    private String password; 

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private List<String> favorites; 

    @DocumentReference
    private List<Review> reviewIDs;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; 
    } 

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
