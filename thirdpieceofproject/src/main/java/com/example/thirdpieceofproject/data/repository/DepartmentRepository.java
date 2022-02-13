package com.example.thirdpieceofproject.data.repository;

import com.example.thirdpieceofproject.data.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findDepartmentById(Long id);

}
