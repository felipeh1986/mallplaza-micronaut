package com.mallplaza.adapter.errors;

import io.micronaut.http.HttpStatus;
import lombok.Getter;

@Getter
public class MallPlazaParkingException extends RuntimeException {

  private HttpStatus status;
  private String message;

  public MallPlazaParkingException(HttpStatus status, String message, Throwable cause) {
    super(cause);
    this.status = status;
    this.message = message;
  }
}
