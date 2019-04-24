package com.everis.d4i.tutorial.entities;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import com.everis.d4i.tutorial.json.ChapterRest;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class TvShow2 {
	private Long id;
	private String name;
	private String shortDescription;
	private Year year;
	private List<ChapterRest> chapters = new ArrayList<>();
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
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}

	public List<ChapterRest> getChapters() {
		return chapters;
	}
	public void setChapters(List<ChapterRest> chapters) {
		this.chapters = chapters;
	}
	

}
