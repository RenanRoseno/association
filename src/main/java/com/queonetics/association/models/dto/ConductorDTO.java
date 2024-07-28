package com.queonetics.association.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConductorDTO {
    private Long id;
    private String name;
    private String registration;
}
