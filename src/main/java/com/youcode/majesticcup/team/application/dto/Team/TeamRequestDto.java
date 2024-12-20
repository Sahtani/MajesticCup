package com.youcode.majesticcup.team.application.dto.Team;

import com.youcode.majesticcup.team.domain.entity.Player;

import java.util.List;

public record TeamRequestDto(String name,
                             String city,
                             List<Player> players) {

}
