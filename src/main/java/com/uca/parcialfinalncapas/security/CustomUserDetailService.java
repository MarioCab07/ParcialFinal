package com.uca.parcialfinalncapas.security;

import com.uca.parcialfinalncapas.entities.UserApi;
import com.uca.parcialfinalncapas.exceptions.UserNotFoundException;
import com.uca.parcialfinalncapas.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserApi userAPI = userRepository.findByCorreo(email).orElseThrow(()->
                new UserNotFoundException("User not found with email: " + email));

        Set<GrantedAuthority> grantedAuthorities = Set.of(
                new SimpleGrantedAuthority("ROLE_"+userAPI.getNombreRol())
        );

        return new User(userAPI.getCorreo(),userAPI.getPassword(),grantedAuthorities);

    }

}

