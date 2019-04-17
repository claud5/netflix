package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "AWARD_FOR_SHOW")
public class AwardForShow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3283401562922075555L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DATE", unique = true)
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SHOW", nullable = false )
	private TvShow tvShow;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AWARD", nullable = false )
	private Award awards;

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TvShow getTvShows() {
		return tvShow;
	}

	public void setTvShows(TvShow tvShows) {
		this.tvShow = tvShows;
	}

	public Award getAwards() {
		return awards;
	}

	public void setAwards(Award awards) {
		this.awards = awards;
	}


	

}