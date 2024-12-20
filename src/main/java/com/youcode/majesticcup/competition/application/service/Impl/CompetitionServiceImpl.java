package com.youcode.majesticcup.competition.application.service.Impl;

import com.youcode.majesticcup.competition.application.dto.Competition.CompetitionRequestDto;
import com.youcode.majesticcup.competition.application.dto.Competition.CompetitionResponseDto;
import com.youcode.majesticcup.competition.application.mapper.CompetitionMapper;
import com.youcode.majesticcup.competition.application.service.CompetitionService;
import com.youcode.majesticcup.competition.domain.entity.Competition;
import com.youcode.majesticcup.competition.domain.entity.Round;
import com.youcode.majesticcup.competition.domain.repository.CompetitionRepository;
import com.youcode.majesticcup.competition.domain.repository.RoundRepository;
import com.youcode.majesticcup.match.domain.repository.MatchRepository;
import com.youcode.majesticcup.team.domain.entity.Team;
import com.youcode.majesticcup.team.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Validated
public class CompetitionServiceImpl implements CompetitionService {


    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final RoundRepository roundRepository;

    @Override
    public CompetitionResponseDto createCompetition(CompetitionRequestDto competitionRequestDTO) {
        Competition competition = competitionMapper.toEntity(competitionRequestDTO);

        List<String> teamsId = competitionRequestDTO.teams();
        List<Team> teams = teamsId.stream()
                .map(teamId -> teamRepository.findById(teamId)
                        .orElseThrow(() -> new RuntimeException("Team not found: " + teamId)))
                .toList();
        competition.setTeams(teams);

        List<String> roundsId = competitionRequestDTO.rounds();
        List<Round> rounds = roundsId.stream()
                .map(roundId -> roundRepository.findById(roundId)
                        .orElseThrow(() -> new RuntimeException("Round not found: " + roundId)))
                .toList();
        competition.setRounds(rounds);


        Competition savedCompetition = competitionRepository.save(competition);
        return competitionMapper.toDto(savedCompetition);

    }


    @Override
    public CompetitionResponseDto getCompetitionById(String competitionId) {
        return competitionRepository.findById(competitionId).map(competitionMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found with ID: " + competitionId));

    }

    @Override
    public CompetitionResponseDto updateCompetition(String id, CompetitionRequestDto competitionRequestDTO) {
        Competition existingCompetition = competitionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Competition not found with ID: " + id));

        Competition updatedCompetition = competitionRepository.save(existingCompetition);
        return competitionMapper.toDto(updatedCompetition);

    }

    @Override
    public List<CompetitionResponseDto> getAllCompetitions() {
        return competitionRepository.findAll()
                .stream()
                .map(competitionMapper::toDto)
                .collect(Collectors.toList());

    }


    @Override
    public void deleteCompetition(String competitionId) {
        if (!competitionRepository.existsById(competitionId)) {
            throw new IllegalArgumentException("Competition not found with ID: " + competitionId);
        }
        competitionRepository.deleteById(competitionId);
    }


}
