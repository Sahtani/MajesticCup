package com.youcode.majesticcup.shared.security.service;

import com.youcode.majesticcup.shared.security.dto.CreateUserDto;
import com.youcode.majesticcup.shared.security.model.Role;
import com.youcode.majesticcup.shared.security.model.User;
import com.youcode.majesticcup.shared.security.model.UserDetailsImpl;
import com.youcode.majesticcup.shared.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
        return new UserDetailsImpl(user);
    }

    public User createUser(CreateUserDto userDto) {
        if (userRepository.findByUsername(userDto.username()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User newUser = new User();
        newUser.setUsername(userDto.username());
        newUser.setPassword(passwordEncoder.encode(userDto.password()));
        newUser.setRole(userDto.role());

        return userRepository.save(newUser);
    }

    // Méthode pour vérifier les credentials
    public boolean validateUser(String username, String password) {
        try {
            UserDetails userDetails = loadUserByUsername(username);
            return passwordEncoder.matches(password, userDetails.getPassword());
        } catch (UsernameNotFoundException e) {
            return false;
        }
    }
}