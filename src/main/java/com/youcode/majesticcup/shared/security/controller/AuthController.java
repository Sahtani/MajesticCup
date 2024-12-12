package com.youcode.majesticcup.shared.security.controller;

import com.youcode.majesticcup.shared.security.dto.CreateUserDto;
import com.youcode.majesticcup.shared.security.model.Role;
import com.youcode.majesticcup.shared.security.model.User;
import com.youcode.majesticcup.shared.security.service.JwtService;
import com.youcode.majesticcup.shared.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Endpoint d'inscription
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody CreateUserDto userDto
            ) {
        User newUser = userService.createUser(userDto);
        return ResponseEntity.ok("Utilisateur enregistré avec succès");
    }

    // Endpoint de connexion
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        // Authentification
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // Générer le token
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
    }
}