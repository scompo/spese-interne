package com.github.scompo.speseinterne.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.scompo.speseinterne.domain.Spesa;

public interface SpesaRepository extends PagingAndSortingRepository<Spesa, Long> {

}
