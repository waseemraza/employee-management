package com.techshowcase.employeemanagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
     Long id;
     String employeeCode;

     @NotNull
     String name;
     String email;
     String department;
     BigDecimal salary;
     String dateOfJoining;

     Instant createdAt;

     Instant updatedAt;
}
