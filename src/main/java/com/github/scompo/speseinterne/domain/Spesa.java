package com.github.scompo.speseinterne.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Spesa implements DomainObject {

	private static final long serialVersionUID = -5501443927125365305L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Utente utente;

	@Column
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataSpesa;

	@Column
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInserimento;

	@Column
	@MoneyFormat
	private BigDecimal valore;

	public Spesa() {

		this(null, null, null, null);
	}

	public Spesa(Utente utente, LocalDate dataSpesa, LocalDate dataInserimento, BigDecimal valore) {

		this.utente = utente;
		this.dataSpesa = dataSpesa;
		this.dataInserimento = dataInserimento;
		this.valore = valore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public LocalDate getDataSpesa() {
		return dataSpesa;
	}

	public void setDataSpesa(LocalDate dataSpesa) {
		this.dataSpesa = dataSpesa;
	}

	public LocalDate getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(LocalDate dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public BigDecimal getValore() {
		return valore;
	}

	public void setValore(BigDecimal valore) {
		this.valore = valore;
	}

	@Override
	public String toString() {
		return "Spesa [id=" + id + ", utente=" + utente + ", dataSpesa=" + dataSpesa + ", dataInserimento="
				+ dataInserimento + ", valore=" + valore + "]";
	}

}
