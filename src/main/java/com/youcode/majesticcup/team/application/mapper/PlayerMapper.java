package com.youcode.majesticcup.team.application.mapper;

import com.youcode.majesticcup.shared.mappers.GenericMapper;
import com.youcode.majesticcup.team.application.dto.Player.PlayerRequestDto;
import com.youcode.majesticcup.team.application.dto.Player.PlayerResponseDto;
import com.youcode.majesticcup.team.domain.entity.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends GenericMapper<Player, PlayerRequestDto, PlayerResponseDto> {
}
