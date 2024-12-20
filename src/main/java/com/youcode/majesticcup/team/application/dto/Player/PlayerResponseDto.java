package com.youcode.majesticcup.team.application.dto.Player;

import com.youcode.majesticcup.team.application.dto.Team.EmbeddedTeamDto;

public record PlayerResponseDto(String id ,
                                String name,
                                String surname,
                                String position,
                                int number,
                                EmbeddedTeamDto team) {
}
