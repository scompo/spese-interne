package com.github.scompo.speseinterne.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.scompo.speseinterne.domain.DettagliUtente;
import com.github.scompo.speseinterne.domain.Utente;
import com.github.scompo.speseinterne.repositories.UtenteRepository;
import com.github.scompo.speseinterne.services.RiassuntoDettagliUtenteService;

@Controller
public class MainController {

	@Autowired
	private RiassuntoDettagliUtenteService utenteDetailsService;

	@Autowired
	private UtenteRepository utenteRepository;

	@RequestMapping("/")
	public String index(Model model) {

		Collection<DettagliUtente> allRiassuntoDettagli = utenteDetailsService.getAllRiassuntoDettagli();
		model.addAttribute("dettagliUtenti", allRiassuntoDettagli);
		System.err.println(allRiassuntoDettagli);
		model.addAttribute("utente", new Utente());
		return "index";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(Utente utente, Model model) {

		System.err.println(utente);
		utenteRepository.save(utente);

		return index(model);
	}
}
