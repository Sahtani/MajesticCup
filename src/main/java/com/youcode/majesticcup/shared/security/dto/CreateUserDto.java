package com.youcode.majesticcup.shared.security.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserDto(@NotBlank(message = "Username is required")
                            @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
                            String username,

                            @NotBlank(message = "Password is required")
                            @Size(min = 8, message = "Password must be at least 8 characters long")
                            @Pattern(
                                    regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
                                    message = "Password must contain at least one letter, one number, and one special character"
                            )
                            String password,

                            @NotBlank(message = "Role is required")
                            @Pattern(
                                    regexp = "^(ADMIN|OPERATOR|USER)$",
                                    message = "Role must be ADMIN, OPERATOR, or USER"
                            )
                            String role) {
}
