package org.enoca.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    @Size(min = 1,max = 50)
    private String name;
    @Column(length = 50)
    @Size(min = 2,max = 50)
    private String surname;
    private String phone;
    @Column(length = 50)
    @Email
    private String email;
    @Column(length = 50)
    private String address;
    @NotBlank(message = "You cannot leave the company ID blank.")
    private Integer companyId;


}
