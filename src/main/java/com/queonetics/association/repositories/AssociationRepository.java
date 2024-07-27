package com.queonetics.association.repositories;

import com.queonetics.association.models.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {

    @Query(" SELECT a FROM Association a WHERE a.plate = ?1 AND a.registration = ?2")
    Association getAssociationByRegistrationAndPlate(String plate, String registration);

    @Query(" SELECT a FROM Association a WHERE a.plate = ?1 AND a.startDate >= ?2 AND a.endDate <= ?3")
    List<Association> getAssociationsByPlateAndPeriod(String plate, LocalDateTime startDate, LocalDateTime endDate);

    @Query(" SELECT a FROM Association a WHERE a.registration = ?1 AND a.endDate >= ?2")
    Association getCurrentAssociationsByRegistration(String registation, LocalDateTime currentDate);

}
