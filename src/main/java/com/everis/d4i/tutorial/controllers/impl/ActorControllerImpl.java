package com.everis.d4i.tutorial.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.d4i.tutorial.controllers.ActorController;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterInShowRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.RestConstants;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTORS)
public class ActorControllerImpl implements ActorController {

	@Autowired
	private ActorService actorService;
	
	
	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<ActorRest>> getActors() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getActors());
	}


	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.PARAMETER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ActorRest> getActorsById(@PathVariable Long id) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getActorsById(id));
	}

	
}