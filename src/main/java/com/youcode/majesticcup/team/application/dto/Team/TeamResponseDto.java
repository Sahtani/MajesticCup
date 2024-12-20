package com.youcode.majesticcup.team.application.dto.Team;

import com.youcode.majesticcup.team.application.dto.Player.EmbeddedPlayerDto;

import java.util.List;

public record TeamResponseDto(String id,
                              String name,
                              String city,
                              List<EmbeddedPlayerDto> players) {
}
