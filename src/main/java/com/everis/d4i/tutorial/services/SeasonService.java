package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.SeasonRest;

public interface SeasonService {

	List<SeasonRest> getSeasonsByTvShow(final Long tvShowId) throws NetflixException;

	SeasonRest getSeasonByTvShowIdAndSeasonNumber(final Long tvShowId, final short seasonNumber)
			throws NetflixException;

}
