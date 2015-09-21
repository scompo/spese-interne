package com.github.scompo.speseinterne.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DettagliUtente {

	private Utente utente;
	
	private BigDecimal totale;
	
	private LocalDate ultimaModifica;
	
	public DettagliUtente(Utente utente, BigDecimal totale, LocalDate ultimaModifica) {
		this.utente = utente;
		this.totale = totale;
		this.ultimaModifica = ultimaModifica;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public BigDecimal getTotale() {
		return totale;
	}

	public void setTotale(BigDecimal totale) {
		this.totale = totale;
	}

	public LocalDate getUltimaModifica() {
		return ultimaModifica;
	}

	public void setUltimaModifica(LocalDate ultimaModifica) {
		this.ultimaModifica = ultimaModifica;
	}

	@Override
	public String toString() {
		return "DettagliUtente [utente=" + utente + ", totale=" + totale + ", ultimaModifica=" + ultimaModifica + "]";
	}

	
}
