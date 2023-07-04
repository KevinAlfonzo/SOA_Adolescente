package com.example.MsAdolescente.domain.mapper;

import com.example.MsAdolescente.domain.dto.AdolescentRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescentResponseDto;
import com.example.MsAdolescente.domain.model.Adolescent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdolescentMapper {

    public static Adolescent toModel(AdolescentRequestDto dto) {
        return new Adolescent(
                dto.getName(),
                dto.getFather_lastname(),
                dto.getMother_lastname(),
                dto.getDni(),
                dto.getBirthday(),
                dto.getAddress(),
                dto.getCellphone(),
                dto.getActive()
        );
    }

    public static Adolescent toModel(Integer id, AdolescentRequestDto dto) {
        return new Adolescent(
                id,
                dto.getName(),
                dto.getFather_lastname(),
                dto.getMother_lastname(),
                dto.getDni(),
                dto.getBirthday(),
                dto.getAddress(),
                dto.getCellphone(),
                dto.getActive()
        );
    }

    public static AdolescentResponseDto toDto(Adolescent model) {
        return new AdolescentResponseDto(
                model.getId(),
                model.getName(),
                model.getFather_lastname(),
                model.getMother_lastname(),
                model.getDni(),
                model.getBirthday(),
                model.getAddress(),
                model.getCellphone(),
                model.getActive()
        );
    }
}
