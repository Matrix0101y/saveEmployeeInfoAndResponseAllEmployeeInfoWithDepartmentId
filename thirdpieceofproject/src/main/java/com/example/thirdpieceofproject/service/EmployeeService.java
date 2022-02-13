package com.example.thirdpieceofproject.service;

import com.example.thirdpieceofproject.data.dto.request.EmployeeInfoRequestDto;
import com.example.thirdpieceofproject.data.dto.response.EmployeeAndDepartmentResponseDto;
import com.example.thirdpieceofproject.data.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeAndDepartmentResponseDto> findEmployeeWithDepartment();

    void saveEmployee(EmployeeInfoRequestDto employeeInfoRequestDto);
}
