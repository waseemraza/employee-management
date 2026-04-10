package com.techshowcase.employeemanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import tools.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("itest")
@AutoConfigureMockMvc

// @Transactional is important — the DB stays running across tests, and @Transactional ensures each
// test's data is rolled back so the next test gets a clean state.
// https://docs.spring.io/spring-framework/reference/testing/testcontext-framework/tx.html#testcontext-tx-enabling-transactions
@Transactional
public abstract class EmployeeManagementApplicationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

}