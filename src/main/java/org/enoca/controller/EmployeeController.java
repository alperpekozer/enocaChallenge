package org.enoca.controller;

import lombok.RequiredArgsConstructor;
import org.enoca.dto.request.EmployeeCreateRequestDto;
import org.enoca.dto.request.EmployeeUpdateRequestDto;
import org.enoca.entity.Employee;
import org.enoca.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("/find-all")
    public ResponseEntity<List>findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }
    @GetMapping("/save")
    public ResponseEntity<Employee> save(Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.findById(id));
    }
    @PostMapping("/update")
    public ResponseEntity<Employee> updateMapper(EmployeeUpdateRequestDto dto){
        return ResponseEntity.ok(employeeService.updateMapper(dto));
    }
    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteById(Integer id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("Deleted Succesful");
    }
    @GetMapping("/create")
    public ResponseEntity<EmployeeCreateRequestDto>createMapper(EmployeeCreateRequestDto dto){
        return ResponseEntity.ok(employeeService.createMapper(dto));
    }
    @GetMapping("find-by-company/{id}")
    public ResponseEntity<List<Employee>> findByCompanyId(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.findByCompanyId(id));
    }
}
