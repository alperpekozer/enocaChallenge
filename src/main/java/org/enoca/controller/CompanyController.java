package org.enoca.controller;

import lombok.RequiredArgsConstructor;
import org.enoca.dto.request.CompanyCreateRequestDto;
import org.enoca.dto.request.CompanyUpdateRequestDto;
import org.enoca.entity.Company;
import org.enoca.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    @GetMapping("/find-all")
    public ResponseEntity<List>findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/create")
    public ResponseEntity<CompanyCreateRequestDto> createMapper(CompanyCreateRequestDto dto){
        return ResponseEntity.ok(companyService.createMapper(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<Company> updateMapper(CompanyUpdateRequestDto dto){
        return ResponseEntity.ok(companyService.updateMapper(dto));
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<Company>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(companyService.findById(id));
    }
    @DeleteMapping("/delete-by-id")
    public ResponseEntity<String> deleteById(Integer id){
        companyService.deleteById(id);
        return ResponseEntity.ok("Deleted Succesful");
    }
}
