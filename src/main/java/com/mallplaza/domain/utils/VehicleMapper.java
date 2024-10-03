package com.mallplaza.domain.utils;

import com.mallplaza.domain.dtos.Vehicle;
import com.mallplaza.domain.entities.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleMapper {

    Vehicle mapToVehicleDTO(VehicleEntity vehicleEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "patent", target = "patent")
    @Mapping(source = "type", target = "type")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "checkInTime", target = "checkInTime")
    VehicleEntity mapToVehicleEntity(Vehicle vehicle);
}
