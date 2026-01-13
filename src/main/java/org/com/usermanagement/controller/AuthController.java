package org.com.usermanagement.controller;

import org.com.usermanagement.dto.LoginRequest;
import org.com.usermanagement.dto.LoginResponse;
import org.com.usermanagement.utilOrSecurity.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Login controller
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        if ("admin".equals(loginRequest.getUsername()) &&
        "password".equals(loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(loginRequest.getUsername());

            return ResponseEntity.ok(new LoginResponse(token));
        }
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
