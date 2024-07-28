package com.queonetics.association.services;

import com.queonetics.association.models.dto.VehicleDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface VehicleService {

    @GetMapping(value = "/vehicles")
    VehicleDTO getVehicleByPlate (@RequestParam String plate);
}
