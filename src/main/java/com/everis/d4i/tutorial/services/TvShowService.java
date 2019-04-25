package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.entities.TvShowChapters;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowRest;

public interface TvShowService {

	List<TvShowRest> getTvShowsByCategory(final Long categoryId) throws NetflixException;

	TvShowRest getTvShowById(final Long id) throws NetflixException;

	TvShowRest updateName(final String name, final Long id) throws NetflixException;

	TvShowRest addCategory(final Long tvShowId, final Long categoryId) throws NetflixException;

	void deleteTvShowById(final Long id) throws NetflixException;

	List<TvShowChapters> getTvShowChapterFromActor(final Long actorId) throws NetflixException;

}
