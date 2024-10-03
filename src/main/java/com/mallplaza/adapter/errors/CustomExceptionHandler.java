package com.mallplaza.adapter.errors;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Produces
@Singleton
@Requires(classes = {MallPlazaParkingException.class, ExceptionHandler.class})
@Slf4j
public class CustomExceptionHandler
    implements ExceptionHandler<MallPlazaParkingException, HttpResponse<ErrorMessage>> {

  @Override
  public HttpResponse<ErrorMessage> handle(
      HttpRequest request, MallPlazaParkingException exception) {

    log.warn("General error: {}", exception.getMessage());

    return HttpResponse.status(exception.getStatus())
            .body(ErrorMessage.builder()
            .message(exception.getMessage())
            .code(exception.getStatus().name())
            .build());
  }
}
