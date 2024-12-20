package com.youcode.majesticcup.competition.infrastructure;

import com.youcode.majesticcup.competition.application.dto.Round.RoundRequestDto;
import com.youcode.majesticcup.competition.application.dto.Round.RoundResponseDto;
import com.youcode.majesticcup.competition.application.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rounds")
@RequiredArgsConstructor
public class RoundController {
    private final RoundService roundService;


    @PostMapping
    public ResponseEntity<RoundResponseDto> createRound(@RequestBody RoundRequestDto roundRequestDTO) {
        return ResponseEntity.ok(roundService.createRound(roundRequestDTO));
    }


    @GetMapping
    public ResponseEntity<List<RoundResponseDto>> getAllRounds() {
        return ResponseEntity.ok(roundService.getAllRounds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoundResponseDto> getRoundById(@PathVariable String id) {
        return ResponseEntity.ok(roundService.getRoundById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoundResponseDto> updateRound(
            @PathVariable String id,
            @RequestBody RoundRequestDto roundRequestDTO) {
        return ResponseEntity.ok(roundService.updateRound(id, roundRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRound(@PathVariable String id) {
        roundService.deleteRound(id);
        return ResponseEntity.noContent().build();
    }
}
