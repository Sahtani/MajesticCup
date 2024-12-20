package com.youcode.majesticcup.competition.application.mapper;

import com.youcode.majesticcup.competition.application.dto.Competition.CompetitionRequestDto;
import com.youcode.majesticcup.competition.application.dto.Competition.CompetitionResponseDto;
import com.youcode.majesticcup.competition.domain.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface CompetitionMapper  {

    @Mapping(target = "teams", ignore = true)
    @Mapping(target = "rounds", ignore = true)
    Competition toEntity(CompetitionRequestDto competitionRequestDTO);
    CompetitionResponseDto toDto(Competition competition);

}
