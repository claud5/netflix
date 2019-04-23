package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.entities.TvShow2;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface TvShowController {

	NetflixResponse<List<TvShowRest>> getTvShowsByCategory( final Long categoryId) throws NetflixException;

	NetflixResponse<TvShowRest> getTvShowById(final Long id) throws NetflixException;

	NetflixResponse<TvShowRest> updateName(final Long tvShowId, final String newName) throws NetflixException;

	NetflixResponse<TvShowRest> addCategory(final Long tvShowId, final Long categoryId) throws NetflixException;

	NetflixResponse<Boolean> deleteTvShowById(final Long tvShowId);

	NetflixResponse<List<TvShow2>> getShowAndChapterFromActor(final Long actorId) throws NetflixException;

}
