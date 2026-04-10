package com.techshowcase.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchParamsDto {
     Long id;
     String employeeCode;
     String name;
     String email;
     String department;
}
