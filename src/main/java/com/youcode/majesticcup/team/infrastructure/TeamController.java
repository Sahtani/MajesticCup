package com.youcode.majesticcup.team.infrastructure;

import com.youcode.majesticcup.team.application.dto.Team.TeamRequestDto;
import com.youcode.majesticcup.team.application.dto.Team.TeamResponseDto;
import com.youcode.majesticcup.team.application.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/teams")

public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/addTeam")
    public ResponseEntity<TeamResponseDto> AddTeam(@RequestBody TeamRequestDto teamRequestDto) {

        TeamResponseDto createdTeam = teamService.createTeam(teamRequestDto);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeamResponseDto>> getAllTeams() {
        List<TeamResponseDto> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }



    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> getTeamById(@PathVariable String id) {
        TeamResponseDto team = teamService.getTeamById(id);
        return ResponseEntity.ok(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDto> updateTeam(
            @PathVariable String id,
            @Valid @RequestBody TeamRequestDto teamRequestDTO) {
        TeamResponseDto updatedTeam = teamService.updateTeam(id, teamRequestDTO);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }



}