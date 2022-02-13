package com.example.thirdpieceofproject.data.repository;

import com.example.thirdpieceofproject.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
