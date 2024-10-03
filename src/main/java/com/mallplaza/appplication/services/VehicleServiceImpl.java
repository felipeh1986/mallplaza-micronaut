package com.mallplaza.appplication.services;

import com.mallplaza.adapter.errors.MallPlazaParkingException;
import com.mallplaza.domain.dtos.Vehicle;
import com.mallplaza.domain.dtos.VehicleOwner;
import com.mallplaza.domain.entities.VehicleEntity;
import com.mallplaza.domain.entities.VehicleOwnerEntity;
import com.mallplaza.domain.repositories.VehicleOwnerRepository;
import com.mallplaza.domain.repositories.VehicleRepository;
import com.mallplaza.domain.utils.VehicleMapper;
import com.mallplaza.domain.utils.VehicleType;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

@Singleton
@Slf4j
public class VehicleServiceImpl implements VehicleService {

  private final VehicleMapper mapper = Mappers.getMapper(VehicleMapper.class);

  @Inject VehicleRepository vehicleRepository;
  @Inject
  VehicleOwnerRepository vehicleOwnerRepository;

  @Override
  public Vehicle getVehicleByPatent(String patent) {
    log.info("Searching info for vehicle {}", patent);
    return mapper.mapToVehicleDTO(findVehicle(patent));
  }

  @Override
  public Vehicle createVehicle(Vehicle vehicle) {

    if (vehicleRepository.findByPatent(vehicle.getPatent()).isPresent()) {
      log.warn("The vehicle with patent {} already exist", vehicle.getPatent());
      throw new MallPlazaParkingException(HttpStatus.CONFLICT, "The vehicle already exist!", null);
    }

    vehicle.setCheckInTime(LocalDateTime.now());
    var vehicleEntity = mapper.mapToVehicleEntity(vehicle);
    vehicleEntity.setVehicleOwner(getVehicleOwner(vehicle.getVehicleOwner()));
    vehicleEntity.setId(UUID.randomUUID());
    vehicleRepository.save(vehicleEntity);
    log.info("The vehicle {} has been created!", vehicle.getPatent());
    return vehicle;
  }

  @Override
  public Vehicle updateVehicle(Vehicle vehicle) {
    var vehicleEntity = findVehicle(vehicle.getPatent());
    vehicleEntity.setColor(vehicle.getColor());
    vehicleEntity.setModel(vehicle.getModel());
    vehicleEntity.setType(VehicleType.valueOf(vehicle.getType()));
    if(Objects.nonNull(vehicle.getCheckInTime())){
      vehicleEntity.setCheckInTime(vehicle.getCheckInTime());
    }
    vehicleEntity.setVehicleOwner(getVehicleOwner(vehicle.getVehicleOwner()));
    vehicleRepository.update(vehicleEntity);
    log.info("The vehicle {} has been updated!", vehicle.getPatent());
    return vehicle;
  }

  @Override
  public void deleteVehicle(String patent) {
    vehicleRepository.delete(findVehicle(patent));
  }

  private VehicleEntity findVehicle(String patent) {
    return vehicleRepository
        .findByPatent(patent)
        .orElseThrow(
            () -> new MallPlazaParkingException(HttpStatus.NOT_FOUND, "Vehicle not found", null));
  }

  private VehicleOwnerEntity getVehicleOwner(VehicleOwner owner){
    if(Objects.nonNull(owner.getDocument())){
      return vehicleOwnerRepository.findByDocument(owner.getDocument()).orElse(createNewOwner(owner));
    }
    return createNewOwner(owner);
  }

  private VehicleOwnerEntity createNewOwner(VehicleOwner owner){
    VehicleOwnerEntity ownerEntity = new VehicleOwnerEntity();
    ownerEntity.setId(UUID.randomUUID());
    ownerEntity.setDocument(owner.getDocument());
    ownerEntity.setName(owner.getName());
    ownerEntity.setLastname(owner.getLastname());

    return ownerEntity;
  }
}
