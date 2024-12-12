package com.youcode.majesticcup.shared.security.mapper;

import com.youcode.majesticcup.shared.security.dto.CreateUserDto;
import com.youcode.majesticcup.shared.security.dto.UserResponseDto;
import com.youcode.majesticcup.shared.security.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",
        imports = {LocalDateTime.class, BCryptPasswordEncoder.class},
        uses = {PasswordEncoder.class})
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "password",
            qualifiedByName = "encodePassword")
    User toEntity(CreateUserDto dto);

    UserResponseDto toResponseDto(User user);

    @Named("encodePassword")
    default String encodePassword(String rawPassword) {
        return new BCryptPasswordEncoder().encode(rawPassword);
    }
}