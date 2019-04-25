package com.everis.d4i.tutorial.json;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.everis.d4i.tutorial.entities.Chapter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class TvShowChaptersByActorRest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5801281096381662783L;
	private Long actorName;
	private String actorSurname;
	private LocalDate dateOfBirth;

	private List<TvShowRest> tvShow = new ArrayList<>();

	public Long getActorName() {
		return actorName;
	}

	public void setActorName(Long actorName) {
		this.actorName = actorName;
	}

	public String getActorSurname() {
		return actorSurname;
	}

	public void setActorSurname(String actorSurname) {
		this.actorSurname = actorSurname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<TvShowRest> getTvShow() {
		return tvShow;
	}

	public void setTvShow(List<TvShowRest> tvShow) {
		this.tvShow = tvShow;
	}


}
