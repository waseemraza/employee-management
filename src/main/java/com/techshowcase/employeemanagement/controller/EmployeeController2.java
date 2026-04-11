package com.techshowcase.employeemanagement.controller;

import com.techshowcase.api.EmployeeApi;
import com.techshowcase.api.model.CreateEmployeeRequestDto;
import com.techshowcase.api.model.CreateEmployeeResponseDto;
import com.techshowcase.employeemanagement.service.EmployeeService2;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

}
