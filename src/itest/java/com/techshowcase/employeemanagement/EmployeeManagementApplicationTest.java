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
@Transactional // after each test class transaction is rolledback which gives clean db for the next test
// https://docs.spring.io/spring-framework/reference/testing/testcontext-framework/tx.html#testcontext-tx-enabling-transactions
public abstract class EmployeeManagementApplicationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

}