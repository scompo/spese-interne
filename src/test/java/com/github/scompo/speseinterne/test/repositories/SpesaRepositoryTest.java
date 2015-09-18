package com.github.scompo.speseinterne.test.repositories;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.speseinterne.domain.Spesa;
import com.github.scompo.speseinterne.domain.Utente;
import com.github.scompo.speseinterne.repositories.SpesaRepository;
import com.github.scompo.speseinterne.repositories.UtenteRepository;
import com.github.scompo.speseinterne.test.IntegrationTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTestConfig
public class SpesaRepositoryTest {

	private static final String TESTNAME = "testname";

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private SpesaRepository spesaRepository;

	private Utente utente;

	@Before
	public void setUp() throws Exception {

		utente = utenteRepository.save(new Utente(TESTNAME));
		spesaRepository.save(new Spesa(utente, LocalDate.now(), LocalDate.now(), new BigDecimal("10")));
		spesaRepository.save(new Spesa(utente, LocalDate.now(), LocalDate.now(), new BigDecimal("11.0")));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSommaSpeseByUtente() {

		BigDecimal res = spesaRepository.sommaSpeseByUtente(TESTNAME);

		assertEquals(new BigDecimal("21.00"), res);
	}

}
