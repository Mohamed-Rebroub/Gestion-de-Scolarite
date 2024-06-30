package com.example.GestionScolarite2.config;

import com.example.GestionScolarite2.entity.User;
import com.example.GestionScolarite2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration

public class UserInfoUserDetailsService  implements UserDetailsService {
    @Autowired
    private UserRepository ourUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = ourUserRepo.findByEmail(username);
        return user.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User Does Not Exist"));
    }
}