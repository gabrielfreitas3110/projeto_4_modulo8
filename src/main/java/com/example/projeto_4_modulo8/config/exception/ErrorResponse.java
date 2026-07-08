package com.example.projeto_4_modulo8.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    private LocalDate timestamp;
    private int status;
    private String error;
    private String message;
    private List<String> details;
}
