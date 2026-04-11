package com.techshowcase.employeemanagement.service;

import com.techshowcase.api.model.CreateEmployeeRequestDto;
import com.techshowcase.api.model.CreateEmployeeResponseDto;
import com.techshowcase.employeemanagement.entity.Employee;
import com.techshowcase.employeemanagement.mapper.EmployeeMapperImpl;
import com.techshowcase.employeemanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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

    private EmployeeService2 employeeService;

    @BeforeEach
    public void setup() {
        employeeService = new EmployeeService2(employeeRepository, new EmployeeMapperImpl());
    }

    @Test
    void testCreateEmployee_Success() {
        final Instant now = Instant.now();
        final CreateEmployeeRequestDto requestDto = new CreateEmployeeRequestDto();
        requestDto.setName("John Doe");
        requestDto.setEmployeeCode("EMP001");
        requestDto.setEmail("john@example.com");
        requestDto.setDepartment("Engineering");
        requestDto.setSalary(BigDecimal.valueOf(50000));
        requestDto.setDateOfJoining(now);

        final Employee savedEmployee = Employee.builder()
                .id(1L)
                .employeeCode("EMP001")
                .name("John Doe")
                .email("john@example.com")
                .department("Engineering")
                .salary(BigDecimal.valueOf(50000))
                .dateOfJoining(now)
                .createdAt(now)
                .updatedAt(now)
                .build();

        when(employeeRepository.save(ArgumentMatchers.any(Employee.class))).thenReturn(savedEmployee);

        CreateEmployeeResponseDto result = employeeService.createEmployee(requestDto);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("EMP001", result.getEmployeeCode());
        assertEquals("John Doe", result.getName());
        assertEquals("john@example.com", result.getEmail());
        assertEquals("Engineering", result.getDepartment());
        assertEquals(BigDecimal.valueOf(50000), result.getSalary());

        verify(employeeRepository).save(ArgumentMatchers.any(Employee.class));
    }
}
