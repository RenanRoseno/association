package com.queonetics.association.services;

import com.queonetics.association.models.Association;
import com.queonetics.association.models.dto.AssociationDTO;
import com.queonetics.association.models.dto.StatusDTO;
import com.queonetics.association.models.dto.VehicleDTO;
import com.queonetics.association.models.enums.EnumStatus;
import com.queonetics.association.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssociationService {
    @Autowired
    AssociationRepository associationRepository;

    @Autowired
    VehicleService vehicleService;

    public Long loginAssociation(AssociationDTO associationDTO) {
        // Verificar no outro servico existencia de veiculo e condutor
        this.validateVehicle(associationDTO.getPlate());
        Association associationSaved = this.associationRepository.save(associationDTO.toEntity());
        return associationSaved.getId();
    }

    public Long logoutAssociation(AssociationDTO associationDTO) {
        //validateExistingConductor(id, conductorDTO.getRegistration());
        Association association = this.associationRepository.getAssociationByRegistrationAndPlate(associationDTO.getPlate(), associationDTO.getRegistration());
        this.validateEndDate(association, associationDTO.getEndDate());
        association.setEndDate(associationDTO.getEndDate());
        this.associationRepository.save(association);
        return association.getId();
    }

    public List<AssociationDTO> listAssociationsByPlateAndPeriod(String plate, LocalDateTime startDate, LocalDateTime endDate) {
        return associationRepository.getAssociationsByPlateAndPeriod(plate, startDate, endDate).stream().map(AssociationDTO::new).collect(Collectors.toList());
    }

    public StatusDTO getStatusByRegistration(@RequestParam String registration) {
        LocalDateTime currentDate = LocalDateTime.now();
        Association existingAssociation = associationRepository.getCurrentAssociationsByRegistration(registration, currentDate);
        StatusDTO statusDTO = new StatusDTO();

        if(existingAssociation != null){
            statusDTO.setStatus(EnumStatus.UNAVAILABLE.getValue());
            statusDTO.setAssociation(new AssociationDTO(existingAssociation));
        }

        statusDTO.setStatus(EnumStatus.AVAILABLE.getValue());
        return statusDTO;
    }

    private void validateEndDate(Association association, LocalDateTime date){
        if(association.getEndDate() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta associação ainda está vigente.");
        }

        if(association.getStartDate().isAfter(date)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data do fim da associação não pode ser maior que a data de início.");
        }
    }

    private void validateVehicle(String plate){
        VehicleDTO vehicleDTO = this.vehicleService.getVehicleByPlate(plate);
        if(vehicleDTO == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O veículo informado não existe.");
    }
}
