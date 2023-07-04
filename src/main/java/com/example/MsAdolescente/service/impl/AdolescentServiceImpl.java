package com.example.MsAdolescente.service.impl;

import com.example.MsAdolescente.domain.dto.AdolescentRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescentResponseDto;
import com.example.MsAdolescente.domain.mapper.AdolescentMapper;
import com.example.MsAdolescente.exception.ResourceNotFoundException;
import com.example.MsAdolescente.repository.AdolescentRepository;
import com.example.MsAdolescente.service.AdolescentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.MsAdolescente.domain.mapper.AdolescentMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdolescentServiceImpl implements AdolescentService {

    private final AdolescentRepository personRepository;

    @Override
    public Mono<AdolescentResponseDto> findById(Integer id) {
        return this.personRepository.findById(id)
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Flux<AdolescentResponseDto> findAll() {
        return this.personRepository.findAll()
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<AdolescentResponseDto> create(AdolescentRequestDto request) {
        return this.personRepository.save(toModel(request))
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<AdolescentResponseDto> update(Integer id, AdolescentRequestDto request) {
        return this.personRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .flatMap(person -> this.personRepository.save(toModel(person.getId(), request)))
                .map(AdolescentMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.personRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id : " + id + " no fue encontrado")))
                .then(this.personRepository.deleteById(id))
                .doOnSuccess(unused -> log.info("Se elimino el usuario con id: {}", id));
    }
}
