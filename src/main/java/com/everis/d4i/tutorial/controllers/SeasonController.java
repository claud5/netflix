package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.SeasonRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface SeasonController {

	NetflixResponse<List<SeasonRest>> getSeasonsByTvShow(final Long tvShowId) throws NetflixException;

	NetflixResponse<SeasonRest> getSeasonByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException;

}
