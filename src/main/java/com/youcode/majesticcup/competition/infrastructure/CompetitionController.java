package com.youcode.majesticcup.competition.infrastructure;

import com.youcode.majesticcup.competition.application.dto.Competition.CompetitionRequestDto;
import com.youcode.majesticcup.competition.application.dto.Competition.CompetitionResponseDto;
import com.youcode.majesticcup.competition.application.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/competitions")
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;

    @PostMapping
    public ResponseEntity<CompetitionResponseDto> createCompetition(@RequestBody CompetitionRequestDto competitionRequestDTO) {
        return ResponseEntity.ok(competitionService.createCompetition(competitionRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<CompetitionResponseDto>> getAllCompetitions() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetitionResponseDto> getCompetitionById(@PathVariable String id) {
        return ResponseEntity.ok(competitionService.getCompetitionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetitionResponseDto> updateCompetition(
            @PathVariable String id,
            @RequestBody CompetitionRequestDto competitionRequestDTO) {
        return ResponseEntity.ok(competitionService.updateCompetition(id, competitionRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable String id) {
        competitionService.deleteCompetition(id);
        return ResponseEntity.noContent().build();
    }
}
