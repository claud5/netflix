package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterRest;

public interface ChapterService {

	List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException;

	ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId, final short seasonNumber,
			final short chapterNumber) throws NetflixException;

	List<ActorRest> getActorsFromChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId,
			final short seasonNumber, final short chapterNumber) throws NetflixException;

	ChapterRest updateChpaterName(final Long tvShowId, final short seasonNumber, final short chapterNumber,
			final String name) throws NetflixException;

}
