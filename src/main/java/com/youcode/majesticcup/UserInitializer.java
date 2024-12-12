package com.youcode.majesticcup;

import com.youcode.majesticcup.shared.security.model.Role;
import com.youcode.majesticcup.shared.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserInitializer implements CommandLineRunner {

    private final UserService userService;

    public UserInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
            userService.createUser("admin", "adminpass", Role.ADMIN);
            userService.createUser("operator", "operatorpass", Role.OPERATOR);

    }
}