package com.youcode.majesticcup.team.application.service.Impl;

import com.youcode.majesticcup.team.application.dto.Team.TeamRequestDto;
import com.youcode.majesticcup.team.application.dto.Team.TeamResponseDto;
import com.youcode.majesticcup.team.application.mapper.TeamMapper;
import com.youcode.majesticcup.team.application.service.TeamService;
import com.youcode.majesticcup.team.domain.entity.Team;
import com.youcode.majesticcup.team.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDTO) {
        Team team = teamMapper.toEntity(teamRequestDTO);
        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDto(savedTeam);
    }


    @Override
    public TeamResponseDto getTeamById(String teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + teamId));
        return teamMapper.toDto(team);
    }

    @Override
    public TeamResponseDto updateTeam(String id, TeamRequestDto teamRequestDTO) {
        Team existingTeam = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + id));

        existingTeam.setName(teamRequestDTO.name());
        existingTeam.setCity(teamRequestDTO.city());

        Team updatedTeam = teamRepository.save(existingTeam);
        return teamMapper.toDto(updatedTeam);
    }

    @Override
    public List<TeamResponseDto> getAllTeams() {
        List<Team> teams = (List<Team>) teamRepository.findAll();
        return teams.stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTeam(String teamId) {
        if (!teamRepository.existsById(teamId)) {
            throw new IllegalArgumentException("Team not found with ID: " + teamId);
        }
        teamRepository.deleteById(teamId);
    } }