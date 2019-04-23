package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface ChapterController {

	NetflixResponse<List<ChapterRest>> getChaptersByTvShowIdAndSeasonNumber(final Long tvShowId,
			final short seasonNumber) throws NetflixException;

	NetflixResponse<ChapterRest> getChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId,
			final short seasonNumber, final short chapterNumber) throws NetflixException;

	NetflixResponse<List<ActorRest>> getActorsFromChapterByTvShowIdAndSeasonNumberAndChapterNumber(final Long tvShowId,
			final short seasonNumber, final short chapterNumber) throws NetflixException;

	NetflixResponse<ChapterRest> updateChapterName(final Long tvShowId, final short seasonNumber,
			final short chapterNumber, final String newName) throws NetflixException;

}
