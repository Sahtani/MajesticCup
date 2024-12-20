package com.youcode.majesticcup.competition.application.dto.Competition;

import java.util.List;

public record CompetitionRequestDto(String name,
                                    int numberOfTeams,
                                    List<String> teams,
                                    int currentRound,
                                    List<String> rounds) {
}
