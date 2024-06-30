package com.example.GestionScolarite2.service;

import com.example.GestionScolarite2.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

public interface UserDetailsService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return null;
    }
}
