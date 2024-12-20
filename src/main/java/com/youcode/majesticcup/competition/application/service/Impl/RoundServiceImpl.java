package com.youcode.majesticcup.competition.application.service.Impl;

import com.youcode.majesticcup.competition.application.dto.Round.RoundRequestDto;
import com.youcode.majesticcup.competition.application.dto.Round.RoundResponseDto;
import com.youcode.majesticcup.competition.application.mapper.RoundMapper;
import com.youcode.majesticcup.competition.application.service.RoundService;
import com.youcode.majesticcup.competition.domain.entity.Competition;
import com.youcode.majesticcup.competition.domain.entity.Round;
import com.youcode.majesticcup.competition.domain.repository.CompetitionRepository;
import com.youcode.majesticcup.competition.domain.repository.RoundRepository;
import com.youcode.majesticcup.match.domain.entity.Match;
import com.youcode.majesticcup.match.domain.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Validated
@RequiredArgsConstructor
public class RoundServiceImpl implements RoundService {


    private final RoundRepository roundRepository;
    private final RoundMapper roundMapper;
    private final CompetitionRepository competitionRepository;
    private final MatchRepository matchRepository;

    @Override
    public RoundResponseDto createRound(RoundRequestDto roundRequestDTO) {
        Round round = roundMapper.toEntity(roundRequestDTO);

        Competition competition = competitionRepository.findById(roundRequestDTO.competition())
                .orElseThrow(()-> new RuntimeException("Competition not found"));

        round.setCompetition(competition);

        List<String> matchIds = roundRequestDTO.matches();
        List<Match> matches = matchIds.stream()
                .map(matchId -> matchRepository.findById(matchId)
                        .orElseThrow(() -> new RuntimeException("Match not found: " + matchId)))
                .toList();
        round.setMatches(matches);

        Round savedRound = roundRepository.save(round);
        return roundMapper.toDto(savedRound);
    }

    @Override
    public RoundResponseDto getRoundById(String roundId) {
     return  roundRepository.findById(roundId).map(roundMapper ::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Round not found with ID: " + roundId));

    }

    @Override
    public RoundResponseDto updateRound(String id, RoundRequestDto roundRequestDTO) {
        Round existingRound = roundRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Round not found with ID: " + id));

        Round updatedRound = roundRepository.save(existingRound);
        return roundMapper.toDto(updatedRound);
    }

    @Override
    public List<RoundResponseDto> getAllRounds() {
        return roundRepository.findAll()
                .stream()
                .map(roundMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRound(String roundId) {
        if (!roundRepository.existsById(roundId)) {
            throw new IllegalArgumentException("Round not found with ID: " + roundId);
        }
        roundRepository.deleteById(roundId);
    }



























}
