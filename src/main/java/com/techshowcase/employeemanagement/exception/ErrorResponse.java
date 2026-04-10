package com.techshowcase.employeemanagement.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class ErrorResponse {
    private String message;
    private List<String> errors;
    private LocalDateTime timestamp;
}
