package com.queonetics.association.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_associations")
@Getter
@Setter
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;

    private String registration;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}

    //"startDate": "2024-07-27T11:34:05"