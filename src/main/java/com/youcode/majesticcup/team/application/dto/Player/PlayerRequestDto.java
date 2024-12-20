package com.youcode.majesticcup.team.application.dto.Player;

public record PlayerRequestDto( String name,
                                String surname,
                                String position,
                                int number,
                                String teamId) {
}
