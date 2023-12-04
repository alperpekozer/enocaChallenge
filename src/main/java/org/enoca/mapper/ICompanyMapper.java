package org.enoca.mapper;

import org.enoca.dto.request.CompanyCreateRequestDto;
import org.enoca.dto.request.CompanyUpdateRequestDto;
import org.enoca.entity.Company;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompanyMapper {

    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);

    Company toCompanySaveDto(final CompanyCreateRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCompanyFromDto(CompanyUpdateRequestDto dto, @MappingTarget Company company);
}
