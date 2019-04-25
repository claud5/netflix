package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.AwardRest;
import com.everis.d4i.tutorial.json.TvShowAwardsRest;

public interface AwardService {

	List<AwardRest> getAwardByTvShow(final Long id) throws NetflixException;

	AwardRest setAwardToTvShow(final Long awardId, final Long tvShowId) throws NetflixException;

	void deleteAward(final Long id) throws NetflixException;

	AwardRest updateAwardName(final Long awardId, final String newName) throws NetflixException;
}