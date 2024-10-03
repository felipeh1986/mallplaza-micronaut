package com.mallplaza.domain.dtos;

import java.util.UUID;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
public class VehicleOwner {

  private UUID id;
  @NotNull
  @NotBlank
  private String document;
  @NotNull
  @NotBlank
  private String name;
  @NotNull
  @NotBlank
  private String lastname;
}
