package com.github.scompo.speseinterne.services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.scompo.speseinterne.domain.DettagliUtente;
import com.github.scompo.speseinterne.domain.Utente;
import com.github.scompo.speseinterne.repositories.SpesaRepository;
import com.github.scompo.speseinterne.repositories.UtenteRepository;

@Service
@Transactional
public class RiassuntoDettagliUtenteServiceImpl implements RiassuntoDettagliUtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private SpesaRepository spesaRepository;

	@Override
	public Collection<DettagliUtente> getAllRiassuntoDettagli() {

		Collection<DettagliUtente> res = new ArrayList<DettagliUtente>();

		for (Utente utente : utenteRepository.findAll()) {

			res.add(new DettagliUtente(utente, spesaRepository.sommaSpeseByUtente(utente.getUsername())));
		}

		return res;
	}

}
