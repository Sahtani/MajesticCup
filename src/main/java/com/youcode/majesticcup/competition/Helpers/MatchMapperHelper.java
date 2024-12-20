package com.youcode.majesticcup.competition.Helpers;

import com.youcode.majesticcup.match.domain.entity.Match;
import com.youcode.majesticcup.match.domain.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MatchMapperHelper {

    private MatchRepository matchRepository;

    public List<Match> fromIds(List<String> matchIds) {
        return matchIds.stream()
                .map(id -> matchRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Match not found: " + id)))
                .toList();
    }

    public List<String> toIds(List<Match> matches) {
        return matches.stream()
                .map(Match::getId)
                .toList();
    }
}
