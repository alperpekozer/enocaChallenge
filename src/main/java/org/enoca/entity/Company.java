package org.enoca.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    @Size(min = 1,max = 50)
    private String name;
    @Column(length = 50)
    private String address;
    @Column(length = 50)
    @Email
    private String email;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> employeeId;

}
