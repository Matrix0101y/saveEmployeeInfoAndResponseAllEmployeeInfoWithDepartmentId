package com.example.thirdpieceofproject.controller;

import com.example.thirdpieceofproject.data.dto.request.EmployeeInfoRequestDto;
import com.example.thirdpieceofproject.data.dto.response.EmployeeAndDepartmentResponseDto;
import com.example.thirdpieceofproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeAndDepartmentResponseDto> getEmployeeWithDepartment(){
        return employeeService.findEmployeeWithDepartment();
    }

    @PostMapping("/")
    public void saveEmployee(@RequestBody EmployeeInfoRequestDto employeeInfoRequestDto){
        employeeService.saveEmployee(employeeInfoRequestDto);
    }


}
