package com.example.thirdpieceofproject.data.dto.response;

import com.example.thirdpieceofproject.data.entity.Department;
import com.example.thirdpieceofproject.data.entity.Employee;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class EmployeeInfoResponseDto {

    private String name;


}
