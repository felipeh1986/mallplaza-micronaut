package com.mallplaza.domain.repositories;

import com.mallplaza.domain.entities.VehicleOwnerEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleOwnerRepository extends CrudRepository<VehicleOwnerEntity, UUID> {

    Optional<VehicleOwnerEntity> findByDocument(String document);
}
