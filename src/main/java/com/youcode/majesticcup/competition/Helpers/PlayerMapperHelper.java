package com.youcode.majesticcup.competition.Helpers;

import com.youcode.majesticcup.team.domain.entity.Player;
import com.youcode.majesticcup.team.domain.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMapperHelper {
    private final PlayerRepository playerRepository;

    @Named("stringToPlayer")
    public Player map(String playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found: " + playerId));
    }
}

