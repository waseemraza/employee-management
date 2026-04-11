package com.techshowcase.employeemanagement.service;

import com.techshowcase.api.model.CreateEmployeeRequestDto;
import com.techshowcase.api.model.CreateEmployeeResponseDto;
import com.techshowcase.employeemanagement.dto.EmployeeSearchParamsDto;
import com.techshowcase.employeemanagement.entity.Employee;
import com.techshowcase.employeemanagement.mapper.EmployeeMapper;
import com.techshowcase.employeemanagement.repository.EmployeeRepository;
import com.techshowcase.employeemanagement.repository.EmployeeSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional // aop transaction management
@RequiredArgsConstructor
public class EmployeeService2 {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    public CreateEmployeeResponseDto createEmployee(final CreateEmployeeRequestDto employeeRequestDto) {
        final Employee employee = mapper.mapRequestDtoToEmployee(employeeRequestDto);
        final Employee savedEmployee = employeeRepository.save(employee);
        return mapper.mapEmployeeToResponseDto(savedEmployee);
    }

    public Page<CreateEmployeeResponseDto> searchEmployees(final EmployeeSearchParamsDto searchParams,
                                                           final Pageable pageable) {
        return employeeRepository.findAll(EmployeeSpecification.fromSearchParams(searchParams), pageable)
                .map(mapper::mapEmployeeToResponseDto);
    }

    /*public EmployeeResponseDto updateEmployee(final Long id, final EmployeeRequestDto requestDto) {
        final Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        final Employee updated = Employee.builder()
                .id(existing.getId())
                .employeeCode(requestDto.getEmployeeCode())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .department(requestDto.getDepartment())
                .salary(requestDto.getSalary())
                .dateOfJoining(existing.getDateOfJoining())
                .createdAt(existing.getCreatedAt())
                .updatedAt(Instant.now())
                .build();
        final Employee saved = employeeRepository.save(updated);
        return mapper.mapEmployeeToResponseDto(saved);
    }*/
}
