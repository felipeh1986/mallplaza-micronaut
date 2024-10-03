package com.mallplaza.fixture;

import com.mallplaza.domain.dtos.Vehicle;
import com.mallplaza.domain.dtos.VehicleOwner;
import java.time.LocalDateTime;
import java.util.UUID;

public class TestDataProvider {

  public static Vehicle buildVehicle(String patent) {
    return Vehicle.builder()
        .id(UUID.randomUUID())
        .patent(patent)
        .type("CAR")
        .color("BLUE")
        .model("2024")
        .checkInTime(LocalDateTime.now())
        .vehicleOwner(buildVehicleOwner())
        .build();
  }

  public static VehicleOwner buildVehicleOwner() {
    return VehicleOwner.builder()
        .id(UUID.randomUUID())
        .document("RUT-123456")
        .name("Jhon")
        .lastname("Doe")
        .build();
  }
}
