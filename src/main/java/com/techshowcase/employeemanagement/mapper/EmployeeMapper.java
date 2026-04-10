package com.techshowcase.employeemanagement.mapper;

import com.techshowcase.employeemanagement.dto.EmployeeRequestDto;
import com.techshowcase.employeemanagement.dto.EmployeeResponseDto;
import com.techshowcase.employeemanagement.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {

    Employee mapRequestDtoToEmployee(final EmployeeRequestDto employeeRequestDto);

    EmployeeResponseDto mapEmployeeToResponseDto(final Employee employee);

}
