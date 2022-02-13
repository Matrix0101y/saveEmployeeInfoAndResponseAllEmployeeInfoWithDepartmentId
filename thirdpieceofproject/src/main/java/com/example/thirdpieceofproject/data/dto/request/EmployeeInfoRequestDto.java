package com.example.thirdpieceofproject.data.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeInfoRequestDto {

    private String name;

    private Long departmentId;


}
