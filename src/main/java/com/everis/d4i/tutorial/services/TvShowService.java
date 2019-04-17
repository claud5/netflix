package com.everis.d4i.tutorial.services;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.TvShowRest;

public interface TvShowService {

	//List<TvShowRest> getTvShowsByCategory(Long categoryId) throws NetflixException;

	TvShowRest getTvShowById(Long id) throws NetflixException;

//	List<Award> getShowAwards(Long id) throws NetflixException;

	TvShowRest updateName(String name, Long id) throws NetflixException;

}
