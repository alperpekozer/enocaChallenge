package org.enoca.mapper;

import org.enoca.dto.request.EmployeeCreateRequestDto;
import org.enoca.dto.request.EmployeeUpdateRequestDto;
import org.enoca.entity.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IEmployeeMapper {

    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);

    Employee toEmployeeSaveDto(final EmployeeCreateRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEmployeeFromDto(EmployeeUpdateRequestDto dto, @MappingTarget Employee employee);
}
