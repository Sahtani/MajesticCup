package com.youcode.majesticcup.competition.Helpers;

import com.youcode.majesticcup.competition.domain.entity.Round;
import com.youcode.majesticcup.competition.domain.repository.RoundRepository;
import com.youcode.majesticcup.team.domain.entity.Team;
import com.youcode.majesticcup.team.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompetitionMapperHelper {

    private TeamRepository teamRepository;

    private RoundRepository roundRepository;

    public List<Team> mapTeams(List<String> teamIds) {
        return teamIds.stream()
                .map(teamId -> teamRepository.findById(teamId)
                        .orElseThrow(() -> new RuntimeException("Team not found: " + teamId)))
                .toList();
    }

    public List<Round> mapRounds(List<String> roundIds) {
        return roundIds.stream()
                .map(roundId -> roundRepository.findById(roundId)
                        .orElseThrow(() -> new RuntimeException("Round not found: " + roundId)))
                .toList();
    }
}
