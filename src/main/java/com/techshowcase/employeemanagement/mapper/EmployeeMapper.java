package com.techshowcase.employeemanagement.mapper;

import com.techshowcase.api.model.CreateEmployeeRequestDto;
import com.techshowcase.api.model.CreateEmployeeResponseDto;
import com.techshowcase.employeemanagement.dto.EmployeeResponseDto;
import com.techshowcase.employeemanagement.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {

    Employee mapRequestDtoToEmployee(final CreateEmployeeRequestDto employeeRequestDto);

    CreateEmployeeResponseDto mapEmployeeToResponseDto(final Employee employee);

    EmployeeResponseDto mapToResponseDto(final Employee employee);

}
