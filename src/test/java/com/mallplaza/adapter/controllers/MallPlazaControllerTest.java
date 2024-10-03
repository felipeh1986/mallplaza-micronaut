package com.mallplaza.adapter.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.mallplaza.domain.dtos.Vehicle;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest
public class MallPlazaControllerTest {

  @Inject
  @Client("/")
  HttpClient httpClient;

  //@Test
  void getVehicleEndpointRespondsWithStatusCode200() {
    var response = httpClient.toBlocking().exchange("/parking/vehicle/MNI335", Vehicle.class);
    assertEquals(HttpStatus.OK, response.getStatus());
    assertNotNull(response.getBody());
  }
}
