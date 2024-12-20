package com.youcode.majesticcup.competition.application.service;

import com.youcode.majesticcup.competition.application.dto.Round.RoundRequestDto;
import com.youcode.majesticcup.competition.application.dto.Round.RoundResponseDto;

import java.util.List;

public interface RoundService {

    RoundResponseDto createRound(RoundRequestDto roundRequestDTO);

    RoundResponseDto getRoundById(String roundId);

    RoundResponseDto updateRound(String id, RoundRequestDto roundRequestDTO);

    List<RoundResponseDto> getAllRounds();

    void deleteRound(String roundId);
}
