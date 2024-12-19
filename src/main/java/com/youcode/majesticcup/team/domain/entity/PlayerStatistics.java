package com.youcode.majesticcup.team.domain.entity;

import lombok.*;
import org.bson.types.ObjectId;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class PlayerStatistics {
    private String playerId;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;


}



