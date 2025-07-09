package com.uca.parcialfinalncapas.service;

import com.uca.parcialfinalncapas.dto.request.LoginRequest;
import com.uca.parcialfinalncapas.dto.request.UserCreateRequest;
import com.uca.parcialfinalncapas.dto.response.UserResponse;

public interface AuthService {
    String login(LoginRequest loginRequest);
    UserResponse register(UserCreateRequest userRequest);
    UserResponse getUserDetails(String jwt);
}
