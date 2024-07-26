package com.queonetics.association.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_associations")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plate;

    private String registration;

    private Date startDate;

    private Date endDate;
}
