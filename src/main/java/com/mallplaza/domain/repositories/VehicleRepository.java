package com.mallplaza.domain.repositories;

import com.mallplaza.domain.entities.VehicleEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleRepository extends CrudRepository<VehicleEntity, UUID> {

    Optional<VehicleEntity> findByPatent(String patent);
}
