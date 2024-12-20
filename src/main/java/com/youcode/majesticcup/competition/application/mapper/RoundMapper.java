package com.youcode.majesticcup.competition.application.mapper;

import com.youcode.majesticcup.competition.application.dto.Round.RoundRequestDto;
import com.youcode.majesticcup.competition.application.dto.Round.RoundResponseDto;
import com.youcode.majesticcup.competition.domain.entity.Round;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoundMapper {

    @Mapping(target = "competition", ignore = true)
    @Mapping(target = "matches", ignore = true)
    Round toEntity(RoundRequestDto roundRequestDTO);
    RoundResponseDto toDto(Round round);

}

