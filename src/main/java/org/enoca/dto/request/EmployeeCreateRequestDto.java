package org.enoca.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateRequestDto {

    private String name;
    private String surname;
    private String phone;
    private String email;
    private String address;
    private Integer companyId;
}
