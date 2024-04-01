package com.example.staff.repository;

import com.example.staff.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByEmployeeNumber(Integer getEmployeeNumber);
    @Query("SELECT e FROM Employee e WHERE " +
            "(:employeeNumber is null or e.employeeNumber = :employeeNumber) and " +
            "(:name is null or e.name like %:name%) and " +
            "(:phone is null or e.phone like %:phone%) and " +
            "(:position is null or e.position like %:position%) and " +
            "(:email is null or e.email like %:email%)")
    Page<Employee> searchEmployees(Integer employeeNumber, String name, String phone, String position, String email, Pageable pageable);
}