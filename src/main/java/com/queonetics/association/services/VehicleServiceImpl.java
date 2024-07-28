package com.queonetics.association.services;

import com.queonetics.association.models.dto.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Override
    public VehicleDTO getVehicleByPlate(String plate) throws HttpClientErrorException {
        String uri = String.format("http://REGISTRATION-API/api/vehicles?plate=%s", plate);
        return restTemplate.getForObject(uri, VehicleDTO.class);
    }
}
