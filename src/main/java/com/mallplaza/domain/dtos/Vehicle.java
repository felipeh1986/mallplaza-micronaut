package com.mallplaza.domain.dtos;

import com.mallplaza.domain.utils.VehicleType;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
@Introspected
public class Vehicle {

    private UUID id;
    @NotBlank
    @NotNull
    private String patent;
    @NotBlank
    @NotNull
    private String type;
    @NotBlank
    @NotNull
    private String color;
    @NotBlank
    @NotNull
    private String model;
    private LocalDateTime checkInTime;
    private VehicleOwner vehicleOwner;
}
