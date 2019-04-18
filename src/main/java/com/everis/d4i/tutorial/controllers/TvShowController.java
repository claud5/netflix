package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.entities.ChapterInShow;
import com.everis.d4i.tutorial.exceptions.NetflixException;
<<<<<<< HEAD
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.AwardForShowRest;
import com.everis.d4i.tutorial.json.AwardRest;
import com.everis.d4i.tutorial.json.ChapterInShowRest;
=======
>>>>>>> 0e562c9d984956d288cbaeda26cde4a0f3857996
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface TvShowController {

	NetflixResponse<List<TvShowRest>> getTvShowsByCategory(Long categoryId) throws NetflixException;

	NetflixResponse<TvShowRest> getTvShowById(Long id) throws NetflixException;

	NetflixResponse<TvShowRest> updateName(Long tvShowId, String newName) throws NetflixException;

	NetflixResponse<TvShowRest> addCategory(Long tvShowId, Long categoryId) throws NetflixException;

	NetflixResponse<Boolean> deleteTvShowById(Long tvShowId);

	NetflixResponse<List<ChapterInShow>> getShowAndChapterFromActor(Long actorId) throws NetflixException;

}
