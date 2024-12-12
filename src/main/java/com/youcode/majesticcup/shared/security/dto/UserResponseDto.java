package com.youcode.majesticcup.shared.security.dto;

import java.time.LocalDateTime;

public record UserResponseDto(
        String id,
        String username,
        String role,
        LocalDateTime createdAt
) {

}