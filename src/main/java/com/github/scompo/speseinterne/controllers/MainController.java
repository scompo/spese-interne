package com.github.scompo.speseinterne.controllers;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.scompo.speseinterne.domain.DettagliUtente;
import com.github.scompo.speseinterne.domain.Spesa;
import com.github.scompo.speseinterne.domain.Utente;
import com.github.scompo.speseinterne.repositories.SpesaRepository;
import com.github.scompo.speseinterne.repositories.UtenteRepository;
import com.github.scompo.speseinterne.services.RiassuntoDettagliUtenteService;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private RiassuntoDettagliUtenteService utenteDetailsService;

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private SpesaRepository spesaRepository;

	@RequestMapping
	public String index(Model model) {

		Collection<DettagliUtente> allRiassuntoDettagli = utenteDetailsService.getAllRiassuntoDettagli();
		model.addAttribute("dettagliUtenti", allRiassuntoDettagli);
		return "index";
	}

	@RequestMapping(value = "utenti", method = RequestMethod.GET)
	public String utenti(Model model) {

		model.addAttribute("utente", new Utente());
		return "inserimento-utenti";
	}

	@RequestMapping(value = "utenti/{username}/spese", method = RequestMethod.GET)
	public String spese(Model model, @PathVariable(value = "username") String username) {

		Utente utente = utenteRepository.findOne(username);
		Spesa spesa = new Spesa();
		spesa.setUtente(utente);
		model.addAttribute("spesa", spesa);
		return "inserimento-spese";
	}

	@RequestMapping(value = "salvaUtente", method = RequestMethod.POST)
	public String saveUser(Utente utente) {

		System.err.println(utente);

		utenteRepository.save(utente);

		return redirectToMain();
	}

	public static String redirectToMain() {

		return "redirect:/";
	}

	@RequestMapping(value = "utenti/{username}/salvaSpesa", method = RequestMethod.POST)
	public String saveSpesa(Spesa spesa, BindingResult bindingResult, @PathVariable(value = "username") String username) {

		System.err.println(bindingResult.getAllErrors());
		spesa.setUtente(utenteRepository.findOne(username));
		spesa.setDataInserimento(LocalDate.now());
		System.err.println(spesaRepository.save(spesa));

		return redirectToMain();
	}
}
