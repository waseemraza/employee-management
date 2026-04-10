package com.techshowcase.employeemanagement.repository;

import com.techshowcase.employeemanagement.dto.EmployeeSearchParamsDto;
import com.techshowcase.employeemanagement.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public final class EmployeeSpecification {

    private EmployeeSpecification() {
    }

    public static Specification<Employee> fromSearchParams(final EmployeeSearchParamsDto params) {

        if (params == null) {
            return (root, query, cb) -> cb.conjunction();
        }
        return Specification
                .where(withId(params.getId()))
                .and(withEmployeeCode(params.getEmployeeCode()))
                .and(withName(params.getName()))
                .and(withEmail(params.getEmail()))
                .and(withDepartment(params.getDepartment()));
    }

    private static Specification<Employee> withId(Long id) {
        if (id == null) {
            return (root, query, cb) -> cb.conjunction();
        }

        return (root, query, cb) -> cb.equal(root.get("id"), id);
    }

    private static Specification<Employee> withEmployeeCode(String employeeCode) {
        if (!StringUtils.hasText(employeeCode)) {
            return (root, query, cb) -> cb.conjunction();
        }
        return (root, query, cb) -> cb.like(cb.lower(root.get("employeeCode")),
                "%" + employeeCode.toLowerCase() + "%");
    }

    private static Specification<Employee> withName(String name) {
        if (!StringUtils.hasText(name)) {
            return (root, query, cb) -> cb.conjunction();
        }
        return (root, query, cb) -> cb.like(cb.lower(root.get("name")),
                "%" + name.toLowerCase() + "%");
    }

    private static Specification<Employee> withEmail(String email) {
        if (!StringUtils.hasText(email)) {
            return (root, query, cb) -> cb.conjunction();
        }
        return (root, query, cb) -> cb.like(cb.lower(root.get("email")),
                "%" + email.toLowerCase() + "%");
    }

    private static Specification<Employee> withDepartment(String department) {
        if (!StringUtils.hasText(department)) {
            return (root, query, cb) -> cb.conjunction();
        }
        return (root, query, cb) -> cb.like(cb.lower(root.get("department")),
                "%" + department.toLowerCase() + "%");
    }
}
