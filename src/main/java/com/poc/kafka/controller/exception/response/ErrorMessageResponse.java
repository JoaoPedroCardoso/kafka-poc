package com.poc.kafka.controller.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class ErrorMessageResponse {

    private final String message;

}
