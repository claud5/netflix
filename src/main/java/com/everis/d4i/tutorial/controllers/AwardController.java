package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.AwardRest;
import com.everis.d4i.tutorial.json.TvShowAwardsRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface AwardController {

	NetflixResponse<List<AwardRest>> getAwardByTvShow(final Long id) throws NetflixException;

	NetflixResponse<AwardRest> setAwardToTvShow(final Long awardId, final Long tvShowId) throws NetflixException;

	NetflixResponse<Boolean> deleteAward(final Long awardId) throws NetflixException;
}