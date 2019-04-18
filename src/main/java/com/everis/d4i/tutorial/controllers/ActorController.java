package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface ActorController {

	NetflixResponse<List<ActorRest>> getActors() throws NetflixException;

	NetflixResponse<ActorRest> getActorsById(Long id) throws NetflixException;

}
