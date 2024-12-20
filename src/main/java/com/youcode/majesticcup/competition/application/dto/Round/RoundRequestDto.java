package com.youcode.majesticcup.competition.application.dto.Round;

import java.util.List;

public record RoundRequestDto(int roundNumber,
                              String competition,
                              List<String> matches) {
}
