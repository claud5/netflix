package com.everis.d4i.tutorial.controllers.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.impl.ActorServiceImpl;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
import com.everis.d4i.tutorial.utils.constants.TestsConstants;


public class ActorControllerImplTest {

	private Actor actor;
	private ActorRest actorRest;
	private List<Actor> actorList;
	private List<ActorRest> actorRestList;

	@Mock
	private ActorServiceImpl actorService; 
	@Mock
	private ActorRepository actorRepository;
	@InjectMocks
	private ActorControllerImpl actorController; 
	
	@Before
	public void init() {
		createActorsStructure();
		MockitoAnnotations.initMocks(this);
	}
	
	private void createActorsStructure() {
		this.actor = new Actor();
		this.actorRest = new ActorRest();
		
		this.actorList = new ArrayList<Actor>();
		this.actorList.add(actor);
		this.actorRestList = new ArrayList<ActorRest>();
		this.actorRestList.add(actorRest);
	}

	
	@Test
	public void getOneActorShouldBeOk() throws Exception {
		// given
		Mockito.when(actorRepository.findById(TestsConstants.ACTOR_ID)).thenReturn(Optional.of(actor));
		Mockito.when(actorService.getActorsById(TestsConstants.ACTOR_ID)).thenReturn(actorRest);

		// when
		NetflixResponse<ActorRest> netflixResponse = actorController.getActorsById(TestsConstants.ACTOR_ID);

		
		// then
		assertEquals(CommonConstants.SUCCESS, netflixResponse.getStatus());
		assertEquals(String.valueOf(HttpStatus.OK),netflixResponse.getCode());
		assertEquals(actorRest, netflixResponse.getData());
		

	}
	
	@Test
	public void getActorsShouldBeOk() throws Exception{
		
		//given
		Mockito.when(actorRepository.findAll()).thenReturn(actorList);
		Mockito.when(actorService.getActors()).thenReturn(actorRestList);
		
		//when
		NetflixResponse<List<ActorRest>> netflixResponse = actorController.getActors();
		
		//then
		assertEquals(CommonConstants.SUCCESS, netflixResponse.getStatus());
		assertEquals(String.valueOf(HttpStatus.OK),netflixResponse.getCode());
		assertEquals(actorRestList.get(TestsConstants.INDEX), netflixResponse.getData().get(TestsConstants.INDEX));
		
	}
	
	//KO
	@Test(expected=NotFoundException.class)
	public void shouldreturnAnActorKo() throws Exception {

		//given
		Mockito.when(actorRepository.findById(TestsConstants.ACTOR_WRONG_ID)).thenReturn(Optional.empty());
		Mockito.when(actorService.getActorsById(TestsConstants.ACTOR_WRONG_ID))
		.thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SHOW));
		
		// when
		actorController.getActorsById(TestsConstants.ACTOR_WRONG_ID);

		// then
		fail();
		
	}
	

	
}
