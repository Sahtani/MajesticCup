package com.youcode.majesticcup.team.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Player {
    private String id;
    private String name;
    private String surname;
    private String position;
    private int number;

}
