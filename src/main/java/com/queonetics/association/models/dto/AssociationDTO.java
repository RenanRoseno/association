package com.queonetics.association.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.queonetics.association.models.Association;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class AssociationDTO {
    private Long id;
    private String plate;
    private String registration;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime endDate;

    public Association toEntity(){
        Association associationEntity = new Association();
        associationEntity.setId(this.id);
        associationEntity.setPlate(this.plate);
        associationEntity.setRegistration(this.registration);
        associationEntity.setStartDate(this.startDate);
        associationEntity.setEndDate(this.endDate);

        return associationEntity;
    }

    public AssociationDTO(Association associationEntity){
        this.id = associationEntity.getId();
        this.plate = associationEntity.getPlate();
        this.registration = associationEntity.getRegistration();
        this.startDate = associationEntity.getStartDate();
        this.endDate = associationEntity.getEndDate();
    }
}
