package com.github.scompo.speseinterne.domain;

import java.math.BigDecimal;

public class DettagliUtente {

	private Utente utente;
	
	private BigDecimal totale;

	public DettagliUtente(Utente utente, BigDecimal totale) {
		
		this.utente = utente;
		this.totale = totale;
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

	@Override
	public String toString() {
		return "DettagliUtente [utente=" + utente + ", totale=" + totale + "]";
	}
	
	
}
