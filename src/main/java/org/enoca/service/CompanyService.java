package org.enoca.service;

import lombok.RequiredArgsConstructor;
import org.enoca.dto.request.CompanyCreateRequestDto;
import org.enoca.dto.request.CompanyUpdateRequestDto;
import org.enoca.entity.Company;
import org.enoca.mapper.ICompanyMapper;
import org.enoca.repository.ICompanyRepository;
import org.enoca.utility.ICrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CompanyService implements ICrudService<Company,Integer> {

    private final ICompanyRepository companyRepository;
    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Iterable<Company> saveAll(Iterable<Company> t) {
        return companyRepository.saveAll(t);
    }

    @Override
    public Company update(Company company) {
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public void delete(Company company) {

    }


    @Override
    public List<Company> findAll() {
        List<Company> companyList = companyRepository.findAll();
        if (companyList.isEmpty()){
            throw new NullPointerException("List is Empty");
        }
        return companyList;
    }

    @Override
    public void deleteById(Integer id) {
        try {
             companyRepository.deleteById(id);
        } catch (Exception e) {
            throw new NullPointerException("Company not found");
        }
    }

    @Override
    public Optional<Company> findById(Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()){
            return optionalCompany;
        }else {
            throw new NullPointerException("Company not found");
        }
    }

    public Company updateMapper(CompanyUpdateRequestDto dto){
        Optional<Company> company = companyRepository.findById(dto.getId());
            ICompanyMapper.INSTANCE.updateCompanyFromDto(dto,company.get());
            return companyRepository.save(company.get());
    }


    public CompanyCreateRequestDto createMapper(CompanyCreateRequestDto dto){
        Company company = ICompanyMapper.INSTANCE.toCompanySaveDto(dto);
        try {
            companyRepository.save(company);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
        return dto;
    }
}

