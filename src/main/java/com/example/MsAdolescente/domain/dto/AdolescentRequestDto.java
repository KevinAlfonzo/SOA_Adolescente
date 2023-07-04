package com.example.MsAdolescente.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AdolescentRequestDto implements Serializable {
    private static final long serialVersionUID = 8222253670338491507L;

    private Integer id;
    private String name;
    private String father_lastname;
    private String mother_lastname;
    private Integer dni;
    private LocalDate birthday;
    private String address;
    private Integer cellphone;
    private String active;

}
