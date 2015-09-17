package com.github.scompo.speseinterne.test.repositories;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.scompo.speseinterne.domain.Utente;
import com.github.scompo.speseinterne.repositories.UtenteRepository;
import com.github.scompo.speseinterne.test.IntegrationTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTestConfig
public class UtenteRepositoryTest {

	@Autowired
	private UtenteRepository utenteRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountEmpty() {

		assertEquals(0L, utenteRepository.count());
	}

	@Test
	public void testSave() {

		Utente res = utenteRepository.save(new Utente("testusername"));

		assertNotNull(res);
		assertTrue(utenteRepository.count() == 1);
	}

}
