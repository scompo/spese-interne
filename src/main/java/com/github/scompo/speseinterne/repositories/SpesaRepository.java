package com.github.scompo.speseinterne.repositories;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.github.scompo.speseinterne.domain.Spesa;

public interface SpesaRepository extends PagingAndSortingRepository<Spesa, Long> {

	@Query("select sum(s.valore) from Spesa s where s.utente.username = :username")
	BigDecimal sommaSpeseByUtente(@Param("username") String username);

	@Query("select max(s.dataSpesa) from Spesa s where s.utente.username = :username")
	LocalDate findMaxDataSpesaByUsername(@Param("username") String username);

}
