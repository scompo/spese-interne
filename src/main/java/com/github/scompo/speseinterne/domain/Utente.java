package com.github.scompo.speseinterne.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Utente implements DomainObject{

	private static final long serialVersionUID = 280002622811827638L;

	@Id
	private String username;

	public Utente() {

		this(null);
	}

	public Utente(String username) {

		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Utente [username=" + username + "]";
	}

}
