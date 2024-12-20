package com.youcode.majesticcup.competition.Helpers;

import com.youcode.majesticcup.team.domain.entity.Team;
import com.youcode.majesticcup.team.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamMapperHelper {
    private final TeamRepository teamRepository;

    @Named("stringToTeam")
    public Team map(String teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found: " + teamId));
    }
}
