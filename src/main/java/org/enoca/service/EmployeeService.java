package org.enoca.service;

import lombok.RequiredArgsConstructor;
import org.enoca.dto.request.EmployeeCreateRequestDto;
import org.enoca.dto.request.EmployeeUpdateRequestDto;
import org.enoca.entity.Employee;
import org.enoca.mapper.IEmployeeMapper;
import org.enoca.repository.IEmployeeRepository;
import org.enoca.utility.ICrudService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class EmployeeService implements ICrudService<Employee,Integer> {

    private final IEmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> saveAll(Iterable<Employee> t) {
        return employeeRepository.saveAll(t);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        if (employeeList.isEmpty()){
            throw new NullPointerException("List is Empty");
        }
        return employeeList;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            employeeRepository.deleteById(id);
        }catch (Exception e) {
            throw new NullPointerException("Employee not found");
        }
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            return optionalEmployee;
        }else {
            throw new NullPointerException("Employee not found");
        }
    }

    public Employee updateMapper(EmployeeUpdateRequestDto dto){
        Optional<Employee> employee = employeeRepository.findById(dto.getId());
        IEmployeeMapper.INSTANCE.updateEmployeeFromDto(dto,employee.get());
        return employeeRepository.save(employee.get());
    }

    public EmployeeCreateRequestDto createMapper(EmployeeCreateRequestDto dto){
        Employee employee = IEmployeeMapper.INSTANCE.toEmployeeSaveDto(dto);
        try {
            employeeRepository.save(employee);
        }catch (Exception e){
            throw new RuntimeException(e.getLocalizedMessage());
        }
        return dto;
    }

    public List<Employee> findByCompanyId(Integer id){
        List<Employee> optionalEmployee = employeeRepository.findByCompanyId(id);
        if (optionalEmployee.isEmpty()){
            throw new NotFoundException("Company Not Found");
        }
        return employeeRepository.findByCompanyId(id);
    }
}

