package br.com.ifce.smash.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDTO {

    private String field;
    private String error;
}
