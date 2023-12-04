package org.enoca.utility;

import lombok.RequiredArgsConstructor;
import org.enoca.entity.Company;
import org.enoca.service.CompanyService;
import org.enoca.service.EmployeeService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataImp implements ApplicationRunner {

    private final CompanyService companyService;
    private final EmployeeService employeeService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //setEmployeeByCompanyId();
    }

    public void setEmployeeByCompanyId(){
        employeeService.findAll().stream().forEach(x ->{
            Company company = companyService.findById(x.getCompanyId()).get();
            company.getEmployeeId().add(x.getId());
            companyService.save(company);
        });
    }
}
