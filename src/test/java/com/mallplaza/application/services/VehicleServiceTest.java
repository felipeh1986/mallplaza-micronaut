package com.mallplaza.application.services;

import static com.mallplaza.fixture.TestDataProvider.buildVehicle;
import static org.junit.jupiter.api.Assertions.*;

import com.mallplaza.adapter.errors.MallPlazaParkingException;
import com.mallplaza.appplication.services.VehicleService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class VehicleServiceTest {

  public static final String PATENT = "ABC123";
  @Inject VehicleService vehicleService;

  @Test
  void shouldBeCreateAVehicleSuccessfully() {
    var vehicle = buildVehicle(PATENT);
    var response = vehicleService.createVehicle(vehicle);
    assertNotNull(response);
  }

  @Test
  void shouldUpdateVehicleSuccessfully() {
    var vehicle = buildVehicle(PATENT);
    vehicleService.createVehicle(vehicle);
    var response = vehicleService.updateVehicle(vehicle);
    assertNotNull(response);
  }

  @Test
  void shouldGetVehicleSuccessfully() {
    vehicleService.createVehicle(buildVehicle(PATENT));
    var response = vehicleService.getVehicleByPatent(PATENT);
    assertNotNull(response);
    assertNotNull(response.getVehicleOwner());
    assertEquals("BLUE", response.getColor());
  }

  @Test
  void shouldDeleteVehicleSuccessfully() {
    vehicleService.createVehicle(buildVehicle(PATENT));
    ;
    vehicleService.deleteVehicle(PATENT);
  }

  @Test
  void shouldFailWhenVehicleNotExist() {
    try {
      vehicleService.getVehicleByPatent(PATENT);
      fail();
    } catch (MallPlazaParkingException ignored) {

    }
  }

  @Test
  void shouldFailWhenVehicleToUpdateNotExist() {
    try {
      vehicleService.updateVehicle(buildVehicle(PATENT));
      fail();
    } catch (MallPlazaParkingException ignored) {

    }
  }

  @Test
  void shouldFailWhenVehicleToCreateAlreadyExist() {
    try {
      var vehicle = vehicleService.createVehicle(buildVehicle(PATENT));
      vehicleService.createVehicle(vehicle);
      fail();
    } catch (MallPlazaParkingException ignored) {

    }
  }
}
