package com.uca.parcialfinalncapas.service.impl;

import com.uca.parcialfinalncapas.dto.request.LoginRequest;
import com.uca.parcialfinalncapas.dto.request.UserCreateRequest;
import com.uca.parcialfinalncapas.dto.response.UserResponse;
import com.uca.parcialfinalncapas.entities.UserApi;
import com.uca.parcialfinalncapas.exceptions.UserNotFoundException;
import com.uca.parcialfinalncapas.repository.UserRepository;
import com.uca.parcialfinalncapas.security.JwtTokenProvider;
import com.uca.parcialfinalncapas.service.AuthService;
import com.uca.parcialfinalncapas.service.UserService;
import com.uca.parcialfinalncapas.utils.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public UserResponse register(UserCreateRequest req){return userService.save(req);}

    @Override
    public String login(LoginRequest req){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getEmail(),
                        req.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(auth);


        return jwtTokenProvider.generateToken(auth);
    }

    @Override
    public UserResponse getUserDetails(String jwt) {
        String username = jwtTokenProvider.getUsernameFromToken(jwt);
        UserApi user = userRepository.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: " + username));
        return UserMapper.toDTO(user);
    }
}
