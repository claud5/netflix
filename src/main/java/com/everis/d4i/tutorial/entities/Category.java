package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 756773556669267707L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;


	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "CATEGORY_FOR_SHOW", 
				joinColumns = { @JoinColumn(name = "CATEGORY_ID") }, 
				inverseJoinColumns = {@JoinColumn(name = "SHOW_ID") })
	private List<TvShow> tvShows = new ArrayList<>();

	
	

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

	public List<TvShow> getTvShows() {
		return tvShows;
	}

	public void setTvShows(List<TvShow> tvShows) {
		this.tvShows = tvShows;
	}

	
}
