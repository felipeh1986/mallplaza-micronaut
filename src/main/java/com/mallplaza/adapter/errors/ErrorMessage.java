package com.mallplaza.adapter.errors;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Serdeable
public class ErrorMessage {

    private String message;
    private String code;
}
