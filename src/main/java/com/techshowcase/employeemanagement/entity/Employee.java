package com.techshowcase.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "employeeCode", nullable = false, unique = true)
    private String employeeCode;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "department", nullable = false)
    private String department;
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
    @Column(name = "dateOfJoining", nullable = false)
    private Instant dateOfJoining;
    private Instant createdAt =  Instant.now();
    private Instant updatedAt =  Instant.now(); // initial value
}
