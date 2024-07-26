package com.queonetics.association.services;

import com.queonetics.association.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociationService {
    @Autowired
    AssociationRepository associationRepository;
}
