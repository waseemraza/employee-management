package com.techshowcase.employeemanagement.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Getter
public class EmployeeResponseDto {
    Long id;
    String employeeCode;
    String name;
    String email;
    String department;
    BigDecimal salary;
    String dateOfJoining;
    Instant createdAt;
    Instant updatedAt;
}
