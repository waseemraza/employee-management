package com.techshowcase.employeemanagement.controller;

import com.techshowcase.employeemanagement.EmployeeManagementApplicationTest;
import com.techshowcase.employeemanagement.EmployeeTestDataHelper;
import com.techshowcase.employeemanagement.dto.EmployeeRequestDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeControllerITest extends EmployeeManagementApplicationTest {

    @Test
    void createAndGetEmployee_Success() throws Exception {

        final EmployeeRequestDto payload = EmployeeTestDataHelper.getEmployeeRequestDto();

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", Matchers.equalTo("John Doe")))
                .andExpect(jsonPath("$.dateOfJoining", Matchers.equalTo("2026-05-02T09:00:00Z")));

        mockMvc.perform(get("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", Matchers.hasSize(1)))
                .andExpect(jsonPath("$.content[0].name", Matchers.equalTo("John Doe")))
                .andExpect(jsonPath("$.content[0].employeeCode", Matchers.equalTo("EMP001")));
    }

}
