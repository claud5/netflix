package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.util.List;

import com.everis.d4i.tutorial.json.ChapterRest;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ChapterInShow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4568741417442266877L;
	
	private Long tvShowId;
	private String tvShowName;
	private String shortDescription;
	
	private List<ChapterRest> chaptersList;

	public Long getTvShowId() {
		return tvShowId;
	}

	public void setTvShowId(Long tvShowId) {
		this.tvShowId = tvShowId;
	}

	public String getTvShowName() {
		return tvShowName;
	}

	public void setTvShowName(String tvShowName) {
		this.tvShowName = tvShowName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public List<ChapterRest> getChaptersList() {
		return chaptersList;
	}

	public void setChaptersList(List<ChapterRest> chaptersList) {
		this.chaptersList = chaptersList;
	}

	public ChapterInShow(Long tvShowId, String tvShowName, String shortDescription, List<ChapterRest> chaptersList) {
		super();
		this.tvShowId = tvShowId;
		this.tvShowName = tvShowName;
		this.shortDescription = shortDescription;
		this.chaptersList = chaptersList;
	}
	
}
