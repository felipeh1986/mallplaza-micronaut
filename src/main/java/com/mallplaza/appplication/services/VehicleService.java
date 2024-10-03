package com.mallplaza.appplication.services;

import com.mallplaza.domain.dtos.Vehicle;

public interface VehicleService {

    Vehicle getVehicleByPatent(String patent);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(String patent);

}
