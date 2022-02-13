package com.example.thirdpieceofproject.service.impl;

import com.example.thirdpieceofproject.data.dto.request.EmployeeInfoRequestDto;
import com.example.thirdpieceofproject.data.dto.response.DepartmentInfoResponseDto;
import com.example.thirdpieceofproject.data.dto.response.EmployeeAndDepartmentResponseDto;
import com.example.thirdpieceofproject.data.dto.response.EmployeeInfoResponseDto;
import com.example.thirdpieceofproject.data.entity.Department;
import com.example.thirdpieceofproject.data.entity.Employee;
import com.example.thirdpieceofproject.data.repository.DepartmentRepository;
import com.example.thirdpieceofproject.data.repository.EmployeeRepository;
import com.example.thirdpieceofproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public List<EmployeeAndDepartmentResponseDto> findEmployeeWithDepartment() {



        List<EmployeeAndDepartmentResponseDto> returnValueList = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();

        /*void accept(T t){

        };
         */
        employeeList.forEach((employee)->{
            EmployeeAndDepartmentResponseDto returnValue = new EmployeeAndDepartmentResponseDto();
            returnValue.setEmployeeName(employee.getName());
            returnValue.setDepartmentName(departmentRepository.findDepartmentById(employee.getDepartment().getId()).getName());
            returnValueList.add(returnValue);
        });

//        for (Employee employee : employeeList) {
//
//            returnValue.setEmployeeName(employee.getName());
////          returnValue.setEmployeeInfoResponseDto(mapEtityToDto(employee));
//            returnValue.setDepartmentName(departmentRepository.findDepartmentById(employee.getDepartment().getId()).getName());
////          returnValue.setDepartmentInfoResponseDto(mapEtityToDto(departmentRepository.findDepartmentById(employee.getDepartment().getId())));
//            returnValueList.add(returnValue);
//        }

        return returnValueList;
    }

    private EmployeeInfoResponseDto mapEtityToDto(Employee employee) {
        return EmployeeInfoResponseDto.builder()
                .name(employee.getName())
                .build();
    }

    private DepartmentInfoResponseDto mapEtityToDto(Department department) {
        return DepartmentInfoResponseDto.builder()
                .name(department.getName())
                .build();
    }


    @Transactional
    @Override
    public void saveEmployee(EmployeeInfoRequestDto employeeInfoRequestDto) {
        Department department = departmentRepository.findDepartmentById(employeeInfoRequestDto.getDepartmentId());
        Employee employee = new Employee();
        employee.setName(employeeInfoRequestDto.getName());
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    private Employee mapDtoToEntity(EmployeeInfoRequestDto employeeInfoRequestDto) {
        Employee employee = new Employee();
        employee.setName(employeeInfoRequestDto.getName());
        return employee;
    }
}
