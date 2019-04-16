package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterRest;

public interface ChapterService {

	List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber) throws NetflixException;

	ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
			short chapterNumber) throws NetflixException;

	List<ActorRest> getActorsFromChapterByTvShowIdAndSeasonNumberAndChapterNumber (Long tvShowId, short seasonNumber,
					short chapterNumber) throws NetflixException;

	ChapterRest updateChpaterName  (Long tvShowId, short seasonNumber, short chapterNumber, String name) throws NetflixException;
	
	
}
