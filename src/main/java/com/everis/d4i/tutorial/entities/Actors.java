package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACTORS")
public class Actors implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1482282774256673014L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "DATE_OF_BIRTH")
	private LocalDate date_of_birth;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ACTORS_IN_CHAPTER", joinColumns = { @JoinColumn(name = "ID_ACTOR") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_CHAPTER") })
	private List<Chapter> chapters = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public void addChapter(Chapter chapter) {
		chapters.add(chapter);
		chapter.getActors().add(this);
	}

	public void removeTag(Chapter chapter) {
		chapters.remove(chapter);
		chapter.getActors().remove(this);
	}

}