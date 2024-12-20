package com.youcode.majesticcup.competition.application.service;

import com.youcode.majesticcup.competition.application.dto.Competition.CompetitionRequestDto;
import com.youcode.majesticcup.competition.application.dto.Competition.CompetitionResponseDto;

import java.util.List;

public interface CompetitionService {

    CompetitionResponseDto createCompetition(CompetitionRequestDto competitionRequestDTO);

    CompetitionResponseDto getCompetitionById(String competitionId);

    CompetitionResponseDto updateCompetition(String id, CompetitionRequestDto competitionRequestDTO);

    List<CompetitionResponseDto> getAllCompetitions();

    void deleteCompetition(String competitionId);
}
