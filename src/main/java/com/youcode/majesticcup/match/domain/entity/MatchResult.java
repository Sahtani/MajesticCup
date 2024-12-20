package com.youcode.majesticcup.match.domain.entity;

import com.youcode.majesticcup.team.domain.entity.PlayerStatistics;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatchResult {
    private int team1Goals;
    private int team2Goals;
    private List<PlayerStatistics> statistics;
}

