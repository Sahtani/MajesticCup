package com.youcode.majesticcup.team.application.service;

import com.youcode.majesticcup.team.application.dto.Team.TeamRequestDto;
import com.youcode.majesticcup.team.application.dto.Team.TeamResponseDto;

import java.util.List;

public interface TeamService {
    TeamResponseDto createTeam(TeamRequestDto teamRequestDTO);

    TeamResponseDto getTeamById(String teamId);
    TeamResponseDto updateTeam(String id, TeamRequestDto teamRequestDTO);
    List<TeamResponseDto> getAllTeams();

    void deleteTeam(String teamId);
}
