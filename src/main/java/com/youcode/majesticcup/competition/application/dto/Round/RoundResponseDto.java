package com.youcode.majesticcup.competition.application.dto.Round;

import java.util.List;

public record RoundResponseDto(String id,
                               int roundNumber,
                               String competition,
                               List<String> matches) {
}
