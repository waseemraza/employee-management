package com.techshowcase.employeemanagement.controller;

import com.techshowcase.employeemanagement.dto.EmployeeRequestDto;
import com.techshowcase.employeemanagement.dto.EmployeeResponseDto;
import com.techshowcase.employeemanagement.dto.EmployeeSearchParamsDto;
import com.techshowcase.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/api/v1/employees")
    public Page<EmployeeResponseDto> searchEmployees(final EmployeeSearchParamsDto searchParams,
                                                     final Pageable pageable) {
        return employeeService.searchEmployees(searchParams, pageable);
    }

    @PutMapping("/api/v1/employees/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable final Long id,
            @Valid @RequestBody final EmployeeRequestDto requestDto) {
        final EmployeeResponseDto updated = employeeService.updateEmployee(id, requestDto);
        return ResponseEntity.ok(updated);
    }
}
