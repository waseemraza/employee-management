package com.techshowcase.employeemanagement.controller;

import com.techshowcase.api.EmployeeApi;
import com.techshowcase.api.model.CreateEmployeeRequestDto;
import com.techshowcase.api.model.CreateEmployeeResponseDto;
import com.techshowcase.api.model.EmployeeSearchParamsDto;
import com.techshowcase.employeemanagement.service.EmployeeService2;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class EmployeeController2 implements EmployeeApi {

    private final EmployeeService2 employeeService;

    @Override
    public ResponseEntity<CreateEmployeeResponseDto> createEmployee(
            @Valid @RequestBody CreateEmployeeRequestDto employeeRequestDto
    ) {

        final CreateEmployeeResponseDto savedEmployee = employeeService.createEmployee(employeeRequestDto);

        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEmployee);
    }

    public ResponseEntity<org.springframework.data.domain.Page<CreateEmployeeResponseDto>> searchEmployees(
            @Parameter(name = "employeeSearchParams", description = "Parameters to search employee(s)", in = ParameterIn.QUERY) @Valid @Nullable EmployeeSearchParamsDto employeeSearchParams,
            @ParameterObject final Pageable pageable
    ) {
        return ResponseEntity.ok(employeeService.searchEmployees(employeeSearchParams, pageable));
    }
}
