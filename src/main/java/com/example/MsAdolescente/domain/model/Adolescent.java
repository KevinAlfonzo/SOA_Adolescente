package com.example.MsAdolescente.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table
@Getter
@Setter
@NoArgsConstructor
public class Adolescent {

    @Id
    private Integer id;
    private String name;
    private String father_lastname;
    private String mother_lastname;
    private Integer dni;
    private LocalDate birthday;
    private String address;
    private Integer cellphone;
    private String active;

    public Adolescent(String name, String father_lastname, String mother_lastname, Integer dni, LocalDate birthday, String address, Integer cellphone, String active) {
        this.name = name;
        this.father_lastname = father_lastname;
        this.mother_lastname = mother_lastname;
        this.dni = dni;
        this.birthday = birthday;
        this.address = address;
        this.cellphone = cellphone;
        this.active = active;
    }

    public Adolescent(Integer id, String name, String father_lastname, String mother_lastname, Integer dni, LocalDate birthday, String address, Integer cellphone, String active) {
        this.id = id;
        this.name = name;
        this.father_lastname = father_lastname;
        this.mother_lastname = mother_lastname;
        this.dni = dni;
        this.birthday = birthday;
        this.address = address;
        this.cellphone = cellphone;
        this.active = active;
    }
}
