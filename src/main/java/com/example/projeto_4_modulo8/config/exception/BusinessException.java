package com.example.projeto_4_modulo8.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class BusinessException extends RuntimeException {

    private final HttpStatus status;
}
