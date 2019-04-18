package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AWARDS")
public class Award implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7953788174326111950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "awards")
	private List<AwardForShow> awardsForShow;

	
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

	public List<AwardForShow> getAwardForShow() {
		return awardsForShow;
	}

	public void setAwardForShow(List<AwardForShow> awardForShow) {
		this.awardsForShow = awardForShow;
	}
	
	
	

}