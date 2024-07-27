package com.queonetics.association.controllers;

import com.queonetics.association.models.dto.AssociationDTO;
import com.queonetics.association.models.dto.StatusDTO;
import com.queonetics.association.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("associations")
public class AssociationController {
    @Autowired
    AssociationService associationService;

    @PostMapping("login")
    public Long loginAssociation(@RequestBody AssociationDTO associationDTO) {
        return associationService.loginAssociation(associationDTO);
    }

    @PutMapping("logout")
    public Long logoutAssociation(@RequestBody AssociationDTO associationDTO) {
        return associationService.logoutAssociation(associationDTO);
    }

    @GetMapping
    public List<AssociationDTO> listAssociationsByPlateAndPeriod(@RequestParam String plate, @RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return associationService.listAssociationsByPlateAndPeriod(plate, startDate, endDate);
    }

    @GetMapping("status")
    public StatusDTO getStatusByRegistration(@RequestParam String registration) {
        return associationService.getStatusByRegistration(registration);
    }

}
