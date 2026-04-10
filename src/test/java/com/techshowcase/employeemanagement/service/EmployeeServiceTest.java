package com.techshowcase.employeemanagement.service;

import com.techshowcase.employeemanagement.EmployeeTestDataHelper;
import com.techshowcase.employeemanagement.dto.EmployeeRequestDto;
import com.techshowcase.employeemanagement.dto.EmployeeResponseDto;
import com.techshowcase.employeemanagement.entity.Employee;
import com.techshowcase.employeemanagement.mapper.EmployeeMapper;
import com.techshowcase.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper mapper;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void testCreateEmployee_Success() {

        final EmployeeRequestDto requestDto = EmployeeTestDataHelper.getEmployeeRequestDto();
        final Employee employee = EmployeeTestDataHelper.getEmployee();

        Employee savedEmployee = Employee.builder()
                .id(1L)
                .employeeCode("EMP001")
                .name("John Doe")
                .email("john@example.com")
                .department("Engineering")
                .salary(BigDecimal.valueOf(50000))
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        EmployeeResponseDto responseDto = EmployeeResponseDto.builder()
                .id(1L)
                .employeeCode("EMP001")
                .name("John Doe")
                .email("john@example.com")
                .department("Engineering")
                .salary(BigDecimal.valueOf(50000))
                .createdAt(savedEmployee.getCreatedAt())
                .updatedAt(savedEmployee.getUpdatedAt())
                .build();

        when(mapper.mapRequestDtoToEmployee(requestDto)).thenReturn(employee);
        when(employeeRepository.save(employee)).thenReturn(savedEmployee);
        when(mapper.mapEmployeeToResponseDto(savedEmployee)).thenReturn(responseDto);

        EmployeeResponseDto result = employeeService.createEmployee(requestDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("EMP001", result.getEmployeeCode());
        assertEquals("John Doe", result.getName());
        assertEquals("john@example.com", result.getEmail());
        assertEquals("Engineering", result.getDepartment());
        assertEquals(BigDecimal.valueOf(50000), result.getSalary());

        verify(mapper).mapRequestDtoToEmployee(requestDto);
        verify(employeeRepository).save(employee);
        verify(mapper).mapEmployeeToResponseDto(savedEmployee);
    }
}
