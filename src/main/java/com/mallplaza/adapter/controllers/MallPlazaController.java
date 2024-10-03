package com.mallplaza.adapter.controllers;

import com.mallplaza.appplication.services.VehicleService;
import com.mallplaza.domain.dtos.Vehicle;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

@Controller("/parking/vehicle")
public class MallPlazaController {

  @Inject VehicleService vehicleService;

  @Post
  public HttpResponse<Vehicle> addVehicle(@Body @Valid Vehicle vehicle) {
    return HttpResponse.created(vehicleService.createVehicle(vehicle));
  }

  @Delete("/{patent}")
  public HttpResponse<String> deleteVehicle(@PathVariable String patent) {
    vehicleService.deleteVehicle(patent);
    return HttpResponse.accepted();
  }

  @Put
  public HttpResponse<Vehicle> updateVehicle(@Body @Valid Vehicle vehicle) {
    return HttpResponse.ok(vehicleService.updateVehicle(vehicle));
  }

  @Get("/{patent}")
  public HttpResponse<Vehicle> getVehicleByPatent(@PathVariable String patent) {
    return HttpResponse.ok(vehicleService.getVehicleByPatent(patent));
  }
}
