package com.example.MsAdolescente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class AdolescentResponseDto implements Serializable {
   private static final long serialVersionUID = 8735757125749188522L;

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
