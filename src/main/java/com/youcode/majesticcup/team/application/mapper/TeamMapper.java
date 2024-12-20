package com.youcode.majesticcup.team.application.mapper;

import com.youcode.majesticcup.shared.mappers.GenericMapper;
import com.youcode.majesticcup.team.application.dto.Team.TeamRequestDto;
import com.youcode.majesticcup.team.application.dto.Team.TeamResponseDto;
import com.youcode.majesticcup.team.domain.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper extends GenericMapper<Team, TeamRequestDto, TeamResponseDto> {
}
