package com.everis.d4i.tutorial.json;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2562292635410148858L;

	private String name;
	private String surname;
	private LocalDate date_of_birth;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	
	@Override
	public String toString() {

		return getName() + " " +
				getSurname() + " " + getDate_of_birth();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
		
	}
}