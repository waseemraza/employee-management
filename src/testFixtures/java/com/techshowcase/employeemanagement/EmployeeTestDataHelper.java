package com.techshowcase.employeemanagement;

import com.techshowcase.employeemanagement.dto.EmployeeRequestDto;
import com.techshowcase.employeemanagement.entity.Employee;

import java.math.BigDecimal;
import java.time.Instant;

public class EmployeeTestDataHelper {

    public static EmployeeRequestDto getEmployeeRequestDto() {
        return EmployeeRequestDto.builder()
                .name("John Doe")
                .employeeCode("EMP001")
                .email("john@example.com")
                .department("Engineering")
                .salary(BigDecimal.valueOf(50000))
                .dateOfJoining("2026-05-02T09:00:00Z")
                .build();
    }

    public static Employee getEmployee() {
        return Employee.builder()
                .employeeCode("EMP001")
                .name("John Doe")
                .email("john@example.com")
                .department("Engineering")
                .salary(BigDecimal.valueOf(50000))
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }
}
